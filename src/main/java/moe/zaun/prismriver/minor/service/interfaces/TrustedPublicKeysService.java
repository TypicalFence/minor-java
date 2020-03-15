package moe.zaun.prismriver.minor.service.interfaces;

import java.security.PublicKey;

public interface TrustedPublicKeysService {
   public PublicKey getPublicKey(final String owner);
}
