package com.github.wangyuheng.utmanual.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.util.Assert;

import java.io.File;

@ConfigurationProperties(prefix = "management.ut")
public class UtProperties {

    private File path;
    private boolean enable;

    public File getPath() {
        return this.path;
    }

    public void setPath(File path) {
        if (null == path) {
            throw new NullPointerException("path is null");
        }
        Assert.isTrue(path.canRead(), () -> "Path '" + path + "' cannot be read");
        Assert.isTrue(path.canWrite(), () -> "Path '" + path + "' cannot be write");
        this.path = path;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
