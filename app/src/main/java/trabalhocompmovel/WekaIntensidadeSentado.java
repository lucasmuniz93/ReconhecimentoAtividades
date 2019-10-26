package trabalhocompmovel;

/**
 * Created by lukaa on 13/11/2017.
 */

public class WekaIntensidadeSentado {
    public static double classify(Object[] i)
            throws Exception {

        double p = Double.NaN;
        p = WekaIntensidadeSentado.N531808350(i);
        return p;
    }
    static double N531808350(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 0.009915) {
            p = WekaIntensidadeSentado.N301c86bf1(i);
        } else if (((Double) i[2]).doubleValue() > 0.009915) {
            p = WekaIntensidadeSentado.N49310ee94(i);
        }
        return p;
    }
    static double N301c86bf1(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 0.06194) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 0.06194) {
            p = WekaIntensidadeSentado.N1c326ffc2(i);
        }
        return p;
    }
    static double N1c326ffc2(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -1.126143) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() > -1.126143) {
            p = WekaIntensidadeSentado.N5a7bfc333(i);
        }
        return p;
    }
    static double N5a7bfc333(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 0.077503) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 0.077503) {
            p = 1;
        }
        return p;
    }
    static double N49310ee94(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 0.095029) {
            p = WekaIntensidadeSentado.N1d4c500e5(i);
        } else if (((Double) i[2]).doubleValue() > 0.095029) {
            p = 2;
        }
        return p;
    }
    static double N1d4c500e5(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 0.892093) {
            p = WekaIntensidadeSentado.N128e91d46(i);
        } else if (((Double) i[0]).doubleValue() > 0.892093) {
            p = 2;
        }
        return p;
    }
    static double N128e91d46(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() <= 1.358545) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() > 1.358545) {
            p = WekaIntensidadeSentado.N17917dd27(i);
        }
        return p;
    }
    static double N17917dd27(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= 0.972764) {
            p = WekaIntensidadeSentado.N56167f8f8(i);
        } else if (((Double) i[4]).doubleValue() > 0.972764) {
            p = 0;
        }
        return p;
    }
    static double N56167f8f8(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= -9.367361) {
            p = WekaIntensidadeSentado.N29a589639(i);
        } else if (((Double) i[3]).doubleValue() > -9.367361) {
            p = WekaIntensidadeSentado.N53a0366511(i);
        }
        return p;
    }
    static double N29a589639(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= 0.920499) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > 0.920499) {
            p = WekaIntensidadeSentado.N4f43adb210(i);
        }
        return p;
    }
    static double N4f43adb210(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 0.24213) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 0.24213) {
            p = 1;
        }
        return p;
    }
    static double N53a0366511(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 0.028243) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 0.028243) {
            p = 1;
        }
        return p;
    }
}
