package ressources.helpers;

public class ReflectionHelper {
    public static class ByteArrayClassLoader extends ClassLoader {
        public Class<?> defineClass(String name, byte[] bytecode) {
            return defineClass(name, bytecode, 0, bytecode.length);
        }
    }
}
