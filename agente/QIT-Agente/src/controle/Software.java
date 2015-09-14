/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.Date;

/**
 *
 * @author eduardo.caron
 */
public class Software {

    private int id;
    private String displayName;
    private String displayVersion;
    private String publisher;
    private String uninstallString;
    private String quietUninstallString;
    private String urlInfoAbout;
    private String helpLink;
    private Date installDate;

    public Software() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getQuietUninstallString() {
        return quietUninstallString;
    }

    public void setQuietUninstallString(String quietUninstallString) {
        this.quietUninstallString = quietUninstallString;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayVersion() {
        return displayVersion;
    }

    public void setDisplayVersion(String displayVersion) {
        this.displayVersion = displayVersion;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getUninstallString() {
        return uninstallString;
    }

    public void setUninstallString(String uninstallString) {
        this.uninstallString = uninstallString;
    }

    public String getUrlInfoAbout() {
        return urlInfoAbout;
    }

    public void setUrlInfoAbout(String urlInfoAbout) {
        this.urlInfoAbout = urlInfoAbout;
    }

    public String getHelpLink() {
        return helpLink;
    }

    public void setHelpLink(String helpLink) {
        this.helpLink = helpLink;
    }

    public Date getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Date installDate) {
        this.installDate = installDate;
    }

}
