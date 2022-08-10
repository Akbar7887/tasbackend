package tas.uz.tasbackend.resource;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tas.uz.tasbackend.models.Model;
import tas.uz.tasbackend.models.News;
import tas.uz.tasbackend.service.NewsService;
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
public class NewsResource {

    final NewsService newsService;
    final FileService fileService;


    @GetMapping("newsget")
    private ResponseEntity<List<News>> getAll(){
        return ResponseEntity.ok().body(newsService.getAll());
    }

    @PostMapping("newsadd")
    private ResponseEntity<News> add(@RequestBody News news){
        return ResponseEntity.ok().body(newsService.add(news));
    }

    @GetMapping("download/news/{filename:.+}")
    public ResponseEntity<?> downloadFile(@PathVariable("filename") String filename, HttpServletRequest request) {
        Resource fileResource = fileService.getFile(filename, "news");

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

    @PostMapping("newsupload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile multipartFile,
                                        @RequestParam String id) throws IOException {
        String filetype = multipartFile.getOriginalFilename();
        String filename = id + "." + filetype.substring(filetype.lastIndexOf(".") +1);

        News news = newsService.getbyid(Long.parseLong(id));
        news.setImagepath(filename);
        newsService.add(news);

        return ResponseEntity.ok(fileService.storeFile(multipartFile, filename, "news"));
    }
}
