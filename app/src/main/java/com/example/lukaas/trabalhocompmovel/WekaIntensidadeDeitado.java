package com.example.lukaas.trabalhocompmovel;

/**
 * Created by Lucas Muniz on 13/11/2017.
 */

public class WekaIntensidadeDeitado {
    public static double classify(Object[] i)
            throws Exception {

        double p = Double.NaN;
        p = WekaIntensidadeDeitado.N5466558d12(i);
        return p;
    }
    static double N5466558d12(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 2.875789) {
            p = WekaIntensidadeDeitado.N279cbb913(i);
        } else if (((Double) i[0]).doubleValue() > 2.875789) {
            p = WekaIntensidadeDeitado.N3e40e97121(i);
        }
        return p;
    }
    static double N279cbb913(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 0.01213) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() > 0.01213) {
            p = WekaIntensidadeDeitado.N31b613f814(i);
        }
        return p;
    }
    static double N31b613f814(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= 7.038155) {
            p = WekaIntensidadeDeitado.N2d23014115(i);
        } else if (((Double) i[1]).doubleValue() > 7.038155) {
            p = WekaIntensidadeDeitado.N7725fac20(i);
        }
        return p;
    }
    static double N2d23014115(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() <= 0.636882) {
            p = 1;
        } else if (((Double) i[3]).doubleValue() > 0.636882) {
            p = WekaIntensidadeDeitado.N4b0fe35516(i);
        }
        return p;
    }
    static double N4b0fe35516(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= 5.21443) {
            p = WekaIntensidadeDeitado.N767cd8e17(i);
        } else if (((Double) i[1]).doubleValue() > 5.21443) {
            p = 0;
        }
        return p;
    }
    static double N767cd8e17(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= 2.615929) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > 2.615929) {
            p = WekaIntensidadeDeitado.N6cf374918(i);
        }
        return p;
    }
    static double N6cf374918(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= 4.885157) {
            p = WekaIntensidadeDeitado.N335307d819(i);
        } else if (((Double) i[1]).doubleValue() > 4.885157) {
            p = 1;
        }
        return p;
    }
    static double N335307d819(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 0.304879) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() > 0.304879) {
            p = 1;
        }
        return p;
    }
    static double N7725fac20(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 0.561273) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() > 0.561273) {
            p = 1;
        }
        return p;
    }
    static double N3e40e97121(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 2;
        } else if (((Double) i[5]).doubleValue() <= 8.511364) {
            p = WekaIntensidadeDeitado.N41cae48f22(i);
        } else if (((Double) i[5]).doubleValue() > 8.511364) {
            p = WekaIntensidadeDeitado.N7f16eb7b24(i);
        }
        return p;
    }
    static double N41cae48f22(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 2;
        } else if (((Double) i[3]).doubleValue() <= 1.73075) {
            p = 2;
        } else if (((Double) i[3]).doubleValue() > 1.73075) {
            p = WekaIntensidadeDeitado.N6a0c56a923(i);
        }
        return p;
    }
    static double N6a0c56a923(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= 6.971054) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > 6.971054) {
            p = 2;
        }
        return p;
    }
    static double N7f16eb7b24(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 0.266028) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > 0.266028) {
            p = 2;
        }
        return p;
    }

}
