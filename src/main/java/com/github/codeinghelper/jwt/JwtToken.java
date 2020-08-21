package com.github.codeinghelper.jwt;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.github.codeinghelper.exception.http.ServerErrorException;
import com.github.codeinghelper.util.DateUtil;
import com.github.codeinghelper.util.StringUtil;
import java.util.*;

/**
 * @author ：frank
 * @BelongsProject: com.github.codeinghelper.jwt
 * @date ：Created in 2020/8/13 11:29
 * @description ：
 * @modified By：
 */
public class JwtToken {
    public static Optional<Map<String, Claim>> getClaims(String token, String jwtKey) {
        DecodedJWT decodedJWT;
        Algorithm algorithm = Algorithm.HMAC256(jwtKey);
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            decodedJWT = jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            return Optional.empty();
        }
        return Optional.of(decodedJWT.getClaims());
    }
    public static Boolean verifyToken(String token, String jwtKey) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(jwtKey);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }


    public static String makeToken(String sessionId, String jwtKey, Integer expiredTimeIn) {
        if (StringUtil.isEmptyOrNull(sessionId) || StringUtil.isEmptyOrNull(jwtKey))
            throw new ServerErrorException(40002);
        return JwtToken.getToken(sessionId, jwtKey, expiredTimeIn);
    }


    private static String getToken(String sessionId, String jwtKey, Integer expiredTimeIn) {
        Algorithm algorithm = Algorithm.HMAC256(jwtKey);
        return JWT.create()
                .withClaim("sessionId", sessionId)
                .withExpiresAt(DateUtil.addSeconds(expiredTimeIn))
                .withIssuedAt(DateUtil.getNow())
                .sign(algorithm);
    }


}
