package tas.uz.tasbackend.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tas.uz.tasbackend.models.Model;
import tas.uz.tasbackend.models.Option;
import tas.uz.tasbackend.service.ModelService;
import tas.uz.tasbackend.service.fileupload.FileService;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.parseMediaType;

@Log4j2
@RequestMapping("/api/")
@RequiredArgsConstructor
@RestController
public class ModelResource {

    final ModelService modelService;
    final FileService fileService;


    @GetMapping("modelget")
    private ResponseEntity<List<Model>> getall(){
        return ResponseEntity.ok().body(
                modelService.getall()
        );
    }

    @PostMapping("modeladd")
    private ResponseEntity<Model> add(@RequestBody Model model, @RequestParam("id") String id){
        return ResponseEntity.ok().body(modelService.add(model, id));
    }

    @PostMapping("modeloption")
    private ResponseEntity<Model> add(@RequestBody Option option, @RequestParam("model_id") String id){
        return ResponseEntity.ok().body(modelService.modeloption(option, id));
    }

    @PostMapping("modelcreate")
    private ResponseEntity<Model> add(@RequestBody Model model){
        return ResponseEntity.ok().body(modelService.create(model));
    }

    @PostMapping("removemodel")
    private ResponseEntity<Model> add(@RequestParam("id") String id) throws IOException {
        return ResponseEntity.ok().body(modelService.remove(id));
    }

    @GetMapping("download/model/{filename:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable("filename") String filename, HttpServletRequest request) {
        Resource fileResource = fileService.getFile(filename, "models");

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

    @PostMapping("modelupload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile,
                                        @RequestParam String id) throws IOException {
        String filetype = multipartFile.getOriginalFilename();
        String filename = id + "." + filetype.substring(filetype.lastIndexOf(".") +1);

        Model model = modelService.getbyid(Long.parseLong(id));
        model.setImagepath(filename);
        modelService.create(model);

        return ResponseEntity.ok(fileService.storeFile(multipartFile, filename, "models"));
    }


}
