package tas.uz.tasbackend.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tas.uz.tasbackend.models.Producer;
import tas.uz.tasbackend.service.ProducerService;
import tas.uz.tasbackend.service.fileupload.FileService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.parseMediaType;

@Log4j2
@RequestMapping("/api/")
@RequiredArgsConstructor
@RestController
public class ProducerResource {

    final ProducerService producerService;
    final FileService fileService;

    @GetMapping("producerget")
    private ResponseEntity<List<Producer>> getall(){
        return ResponseEntity.ok().body(producerService.getall());
    }

    @PostMapping("produceradd")
    private ResponseEntity<Producer> add(@RequestBody Producer producer){
        return ResponseEntity.ok().body(producerService.add(producer));
    }
    @PostMapping("removeproducer")
    private ResponseEntity<Producer> add(@RequestParam("id") String id){
        return ResponseEntity.ok().body(producerService.remove(id));
    }
    @GetMapping("download/producer/{filename:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable("filename") String filename, HttpServletRequest request) {
        Resource fileResource = fileService.getFile(filename, "producers");

        String contentType = null;

        try {
            contentType = request.getServletContext().getMimeType(fileResource.getFile().getAbsolutePath());
        } catch (IOException e) {
            log.error("Could not determine file type.");
        }

        if (contentType == null) {
            contentType = "application/octet-stream";
        }
        return ResponseEntity.ok()
                .contentType(parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileResource.getFilename() + "\"")
                .body(fileResource);
    }

    @PostMapping("producerupload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile,
                                        @RequestParam String id) throws IOException {
        String filetype = multipartFile.getOriginalFilename();
        String filename = id + "." + filetype.substring(filetype.lastIndexOf(".") +1);

        Producer producer = producerService.getbyid(Long.parseLong(id));
        producer.setImagepath(filename);
        producerService.add(producer);

        return ResponseEntity.ok(fileService.storeFile(multipartFile, filename, "producers"));
    }

}
