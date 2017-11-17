package com.example.lukaas.trabalhocompmovel;

/**
 * Created by Lucas Muniz on 13/11/2017.
 */


public class WekaIntensidadeAndando {
    public static double classify(Object[] i)
            throws Exception {

        double p = Double.NaN;
        p = WekaIntensidadeAndando.N10e9bcdc36(i);
        return p;
    }
    static double N10e9bcdc36(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 6.896479) {
            p = WekaIntensidadeAndando.N1de3ce3337(i);
        } else if (((Double) i[2]).doubleValue() > 6.896479) {
            p = WekaIntensidadeAndando.N49033dc344(i);
        }
        return p;
    }
    static double N1de3ce3337(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 2.210205) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() > 2.210205) {
            p = WekaIntensidadeAndando.N5ec2340d38(i);
        }
        return p;
    }
    static double N5ec2340d38(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() <= -0.696032) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() > -0.696032) {
            p = WekaIntensidadeAndando.N17fb6fb539(i);
        }
        return p;
    }
    static double N17fb6fb539(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 4.669939) {
            p = WekaIntensidadeAndando.N4a293eca40(i);
        } else if (((Double) i[4]).doubleValue() > 4.669939) {
            p = WekaIntensidadeAndando.N4a5f952c43(i);
        }
        return p;
    }
    static double N4a293eca40(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -1.855154) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > -1.855154) {
            p = WekaIntensidadeAndando.N4938e3ea41(i);
        }
        return p;
    }
    static double N4938e3ea41(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 3.568575) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() > 3.568575) {
            p = WekaIntensidadeAndando.N615d49c42(i);
        }
        return p;
    }
    static double N615d49c42(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -0.516537) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > -0.516537) {
            p = 0;
        }
        return p;
    }
    static double N4a5f952c43(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -0.898951) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() > -0.898951) {
            p = 1;
        }
        return p;
    }
    static double N49033dc344(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 5.819407) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 5.819407) {
            p = WekaIntensidadeAndando.N47aaa0ba45(i);
        }
        return p;
    }
    static double N47aaa0ba45(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 2;
        } else if (((Double) i[2]).doubleValue() <= 10.983705) {
            p = WekaIntensidadeAndando.N6fb33de746(i);
        } else if (((Double) i[2]).doubleValue() > 10.983705) {
            p = 2;
        }
        return p;
    }
    static double N6fb33de746(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 2;
        } else if (((Double) i[1]).doubleValue() <= -1.425254) {
            p = 2;
        } else if (((Double) i[1]).doubleValue() > -1.425254) {
            p = 1;
        }
        return p;
    }
}

