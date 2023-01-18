package com.alperenikinci.service;

import com.alperenikinci.dto.request.CreateProfileRequestDto;
import com.alperenikinci.dto.request.DoLoginRequestDto;
import com.alperenikinci.dto.request.RegisterRequestDto;
import com.alperenikinci.dto.response.RegisterResponseDto;
import com.alperenikinci.exception.AuthMicroserviceException;
import com.alperenikinci.exception.ErrorType;
import com.alperenikinci.manager.IUserProfileManager;
import com.alperenikinci.mapper.IAuthMapper;
import com.alperenikinci.repository.IAuthRepository;
import com.alperenikinci.repository.entity.Auth;
import com.alperenikinci.utility.ServiceManager;
import com.alperenikinci.utility.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService extends ServiceManager<Auth, Long> {

    private final IAuthRepository repository;
    /**
     * DİKKAT!!!!!!
     * kullanmak istediğiniz interface, service, component gibi sınıflardan nesne türetmek
     * için 2 yolumuz var.
     * @Autowired ile işaretlemek ya da Constructor Injection ile kullanmak.
     */

    private final IUserProfileManager userProfileManager;
    private final TokenGenerator tokenGenerator;

    public AuthService(IAuthRepository repository, IUserProfileManager userProfileManager, TokenGenerator tokenGenerator){
        super(repository);
        this.repository=repository;
        this.userProfileManager = userProfileManager;
        this.tokenGenerator = tokenGenerator;
    }

    public RegisterResponseDto save(RegisterRequestDto dto){
        /**
         * Eğer şifre ile ikinci şifre uyuşmuyor ise, direkt false
         * dönülmesi mantıklıdır.
         */
        if(!dto.getPassword().equals(dto.getRepassword()))
            throw new AuthMicroserviceException(ErrorType.REGISTER_REPASSWORD_ERROR);
        /**
         * Burada elle dönüşüp yerine Mapper(MapStruct) kullanmak daha
         * doğru olacaktır.
         */
    /*  Elle dönüşüm işlemi
        save(Auth.builder()
                .email(dto.getEmail())
                .password(dto.getPassword())
                .username(dto.getUsername())
                .build()
        );*/
        if(repository.findOptionalByUsername(dto.getUsername()).isPresent())
            throw new AuthMicroserviceException(ErrorType.REGISTER_KULLANICIADI_KAYITLI);
        Auth auth = save(IAuthMapper.INSTANCE.fromRegisterRequestDto(dto));
        userProfileManager.createProfile(CreateProfileRequestDto.builder()
                        .token("")
                        .authId(auth.getId())
                        .username(auth.getUsername())
                        .email(auth.getEmail())
                        .build());
        RegisterResponseDto result = IAuthMapper.INSTANCE.fromAuth(auth);
        result.setRegisterState(100);
        result.setContent(auth.getEmail()+" ile başarılı şekilde kayıt oldunuz.");
        return result;

    }

    public String doLogin(DoLoginRequestDto dto){
      Optional<Auth> auth =  repository.findOptionalByUsernameAndPassword(dto.getUsername(), dto.getPassword());
      if(auth.isEmpty()){
          throw new AuthMicroserviceException(ErrorType.LOGIN_ERROR);
      }
        /**
         * Login olan kişiler için özel bir token üretmek mantıklıdır.
         */

       return tokenGenerator.createToken(auth.get().getId());

    }
}
