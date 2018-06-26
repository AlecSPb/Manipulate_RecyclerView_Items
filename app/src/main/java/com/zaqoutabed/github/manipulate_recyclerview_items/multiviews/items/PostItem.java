package com.zaqoutabed.github.manipulate_recyclerview_items.multiviews.items;

public abstract class PostItem implements IItem {
    private String userName;
    private int userImageRcs;

    public PostItem(String userName, int userImageRcs) {
        this.userName = userName;
        this.userImageRcs = userImageRcs;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserImageRcs() {
        return userImageRcs;
    }

    public void setUserImageRcs(int userImageRcs) {
        this.userImageRcs = userImageRcs;
    }
}
