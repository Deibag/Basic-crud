package test.back.rest;

import java.util.List;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test.back.model.BoxDTO;
import test.back.service.BoxService;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/boxs", produces = MediaType.APPLICATION_JSON_VALUE)
public class BoxController {

    private final BoxService boxService;

    public BoxController(final BoxService boxService) {
        this.boxService = boxService;
    }

    @GetMapping
    public ResponseEntity<List<BoxDTO>> getAllBoxs() {
        return ResponseEntity.ok(boxService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BoxDTO> getBox(@PathVariable final Integer id) {
        return ResponseEntity.ok(boxService.get(id));
    }

    @PostMapping
    public ResponseEntity<Integer> createBox(@RequestBody @Valid final BoxDTO boxDTO) {
        return new ResponseEntity<>(boxService.create(boxDTO), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBox(@PathVariable final Integer id,
            @RequestBody @Valid final BoxDTO boxDTO) {
        boxService.update(id, boxDTO);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBox(@PathVariable final Integer id) {
        boxService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
