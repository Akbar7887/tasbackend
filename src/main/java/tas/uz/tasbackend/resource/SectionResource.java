package tas.uz.tasbackend.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.expression.spel.ast.Selection;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tas.uz.tasbackend.models.Section;
import tas.uz.tasbackend.service.SectionService;
import tas.uz.tasbackend.service.fileupload.FileService;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.parseMediaType;

@Log4j2
@RequestMapping("/api/")
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class SectionResource {

    final SectionService sectionService;
    final FileService fileService;

    @PostMapping("sectionadd")
    private ResponseEntity<Section> add(@RequestBody Section section) {
        return ResponseEntity.ok().body(sectionService.add(section));
    }

    @GetMapping("sectionget")
    private ResponseEntity<List<Section>> get(){
        return ResponseEntity.ok().body(sectionService.get());
    }

    @GetMapping("download/section/{filename:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable("filename") String filename, HttpServletRequest request) {
        Resource fileResource = fileService.getFile(filename, "section");

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

    @PostMapping("sectionupload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile,
                                        @RequestParam String id) throws IOException {
        String filetype = multipartFile.getOriginalFilename();
        String filename = id + "." + filetype.substring(filetype.lastIndexOf(".") +1);

        Section section = sectionService.getbyid(Long.parseLong(id));
        section.setImagepath(filename);
        sectionService.add(section);

        return ResponseEntity.ok(fileService.storeFile(multipartFile, filename, "section"));
    }
}
