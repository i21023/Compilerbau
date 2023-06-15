package mmc.semantikcheck.Environment;

import mmc.ast.Type;

public class ScopeInitialized {
        public Type type;
        public boolean isInitialized;

        public ScopeInitialized(Type pType, boolean pIsInitialized){
                type = pType;
                isInitialized = pIsInitialized;
        }
}
