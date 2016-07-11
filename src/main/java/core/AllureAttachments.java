package core;

import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllureAttachments {
    @Attachment(value = "{0}", type = "image/png")
    public static byte[] saveImageAttach(String attachName, String screenPath) {
        try {
            File imageFile = new File(screenPath);
            return toByteArray(imageFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    private static byte[] toByteArray(File file) throws IOException {
        return Files.readAllBytes(Paths.get(file.getPath()));
    }
}
