package com.dake.springboot.main;

import java.math.BigInteger;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.NamedParameterSpec;

public class Jdk15Main {

    public static void main(String[] args) {
        String a = """
                    abc
                    cde
                """;

        // instanceof 中的模式匹配 是预览功能，默认情况下禁用
        // 请使用 --enable-preview 以启用 instanceof 中的模式匹配
//        if (a instanceof String str) {
//            char c = str.charAt(1);
//        }
    }

    class EdDSA {

        public void generateSign() throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, InvalidKeySpecException {
            // example: generate a key pair and sign
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
            KeyPair kp = kpg.generateKeyPair();
            // algorithm is pure Ed25519
            Signature sig = Signature.getInstance("Ed25519");
            sig.initSign(kp.getPrivate());
//            sig.update(msg);
            byte[] s = sig.sign();

            // example: use KeyFactory to contruct a public key
            KeyFactory kf = KeyFactory.getInstance("EdDSA");
            boolean xOdd = true;
            BigInteger y = new BigInteger("10");
            NamedParameterSpec paramSpec = new NamedParameterSpec("Ed25519");
//            EdECPublicKeySpec pubSpec = new EdECPublicKeySpec(paramSpec, new EdPoint(xOdd, y));
//            PublicKey pubKey = kf.generatePublic(pubSpec);

        }


    }

}
