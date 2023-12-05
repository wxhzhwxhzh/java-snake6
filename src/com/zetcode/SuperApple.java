package com.zetcode;

import com.zetcode.MyUtil.Config;

public class SuperApple extends Apple {
    {
        super.AppleImg = Config.SuperAppleImg;
        super.isVisible=true;
    }

    @Override
    public Apple reset() {
        super.reborn();
        return this;
    }

}
