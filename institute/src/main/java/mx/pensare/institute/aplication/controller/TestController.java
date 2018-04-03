package mx.pensare.institute.aplication.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by dolphins on 1/26/18.
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/{id}")
    public String getAll(@PathVariable Long id) {
        return "Test, el id es: " + id;
    }

}