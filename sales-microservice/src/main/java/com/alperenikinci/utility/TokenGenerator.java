package com.alperenikinci.utility;

import com.alperenikinci.exception.ErrorType;
import com.alperenikinci.exception.SalesMicroserviceException;
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
                throw new SalesMicroserviceException(ErrorType.INVALID_TOKEN);
            String userid = token.split(":")[1];
            return Long.parseLong(userid);
        } catch (Exception e){
            throw new SalesMicroserviceException(ErrorType.INVALID_TOKEN);
        }


    }
}
