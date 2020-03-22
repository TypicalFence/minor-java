package moe.zaun.prismriver.minor.service;

import moe.zaun.prismriver.minor.service.interfaces.TrustedPublicKeysService;
import moe.zaun.prismriver.minor.util.PemUtils;

import java.io.IOException;
import java.security.PublicKey;

public class FakeTrustedPublicKeyService implements TrustedPublicKeysService {

    public PublicKey getPublicKey(final String owner) {
        if (owner.equals("fence")) {
            String dir = "/home/fence/code/java/minor-aws";
            try {
                return PemUtils.readPublicKeyFromFile(dir + "/mykey.pub", "RSA");
            } catch(IOException e) {
                return null;
            }
        }

        return null;
    };

}
