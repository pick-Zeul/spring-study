package org.example.study.menu.controller;

import lombok.RequiredArgsConstructor;
import org.example.study.menu.dto.MenuSaveDto;
import org.example.study.menu.menuservice.MenuService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // rest api - url을 통해 값을 주고 받는다
@RequestMapping("/menu")// http://localhost:8080/menu
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MenuController {
    private final MenuService menuService;

    @PostMapping// http://localhost:8080/menu
    public Long menuSave(@RequestBody MenuSaveDto menuSaveDto) {
        return menuService.saveMenu(menuSaveDto); // saveMenu 메소드에 값 입력
    }
    // rest api 메소드는 5가지 get, post, delete, patch, put
    // get -> 값을 가져옴 - 화면 기준으로 말하는 거라서 서버는 데이터를 전송해줌
    // post -> 값을 입력함 - 서버에 값을 전송
    // delete -> 값 삭제 요청 - 서버에게 특정 데이터를 삭제하도록 함
    // patch, put -> 값 수정
/*
    @PatchMapping("/{id}")
    // http://localhost:8080/menu/{id}
    // http://localhost:8080/menu/1
    public ResponseEntity menuUpdate(@PathVariable Long id, @RequestBody MenuUpdateDto menuUpdateDto) {
        menuService.updateMenu(id, menuUpdateDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity menuDelete(@PathVariable Long id) {
        menuService.deleteMenu(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping
    public List<ResponseMenuDto> menuFindAll() {
        return menuService.findAllMenus();
    }*/
}