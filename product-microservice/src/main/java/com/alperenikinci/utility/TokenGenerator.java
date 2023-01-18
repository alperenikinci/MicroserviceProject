package com.alperenikinci.utility;

import com.alperenikinci.exception.ErrorType;
import com.alperenikinci.exception.ProductMicroserviceException;
import org.springframework.stereotype.Component;

@Component
public class TokenGenerator {

    public String createToken(Long userid) {
        String token = "Brr:"+userid;
        return token;
    }

    public Long decodeToken(String token) {

        try{
            if(!token.split(":")[0].equals("Brr"))
                throw new ProductMicroserviceException(ErrorType.INVALID_TOKEN);
            String userid = token.split(":")[1];
            return Long.parseLong(userid);
        } catch (Exception e){
            throw new ProductMicroserviceException(ErrorType.INVALID_TOKEN);
        }


    }
}
