package org.personal.hackerton.Data;

import android.graphics.drawable.Drawable;

public class FriendItem {
    String nickname;
    Drawable profileImage;

    public FriendItem(String nickname, Drawable profileImage) {
        this.nickname = nickname;
        this.profileImage = profileImage;
    }

    public String getName() {
        return nickname;
    }

    public void setName(String nickname) {
        this.nickname = nickname;
    }

    public Drawable getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(Drawable profileImage) {
        this.profileImage = profileImage;
    }

}