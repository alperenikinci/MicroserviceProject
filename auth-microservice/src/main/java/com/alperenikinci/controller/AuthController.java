package com.alperenikinci.controller;

import com.alperenikinci.dto.request.DoLoginRequestDto;
import com.alperenikinci.dto.request.RegisterRequestDto;
import com.alperenikinci.dto.response.RegisterResponseDto;
import com.alperenikinci.repository.entity.Auth;
import com.alperenikinci.repository.entity.State;
import com.alperenikinci.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.alperenikinci.contstants.RestApi.*;

@RestController
@RequestMapping(AUTH)
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Value("${buuygulama.birdeger}")
    private String BuradaYMLdanDegerAlalim;

    /**
     * Bir end point e istek atarken farklı yollarla parametre gönderilebilir.
     * 1- Header, boşluk içinde
     * 2- Body, form elementi içinde
     * burada body içinde parametreleri almak daha güvenlidir.
     *
     * @Valid
     * girilen bilgilerin belli kriterleri olmalıdır. mesela şifrenin karmaşıklığı
     * email adresinin doğru formatta olması vs.
     * @param dto
     * @return
     */
    @PostMapping(DOLOGIN)
    public ResponseEntity<String> doLogin(@RequestBody @Valid DoLoginRequestDto dto){

        return ResponseEntity.ok(authService.doLogin(dto));
    }

    @CrossOrigin("*")
    @PostMapping(REGISTER)
    public ResponseEntity<RegisterResponseDto> register(@RequestBody @Valid RegisterRequestDto dto){
        System.out.println("gelen değer....." + BuradaYMLdanDegerAlalim);
        return ResponseEntity.ok(authService.save(dto));
    }

    @GetMapping("/say")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Selam arkadaşlar ben Auth");
    }

}
