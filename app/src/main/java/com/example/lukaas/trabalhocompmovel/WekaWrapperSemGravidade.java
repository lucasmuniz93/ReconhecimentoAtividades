package com.example.lukaas.trabalhocompmovel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by lukaa on 05/11/2017.
 */

public class WekaWrapperSemGravidade extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reconhecimento);
    }

    public static double classify(Object[] i)
            throws Exception {

        double p = Double.NaN;
        p = WekaWrapperSemGravidade.N38265ec0(i);
        return p;
    }
    static double N38265ec0(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 4;
        } else if (((Double) i[3]).doubleValue() <= -7.44524) {
            p = WekaWrapperSemGravidade.N3918ef5d1(i);
        } else if (((Double) i[3]).doubleValue() > -7.44524) {
            p = WekaWrapperSemGravidade.N78710c8630(i);
        }
        return p;
    }
    static double N3918ef5d1(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 4;
        } else if (((Double) i[2]).doubleValue() <= 0.638822) {
            p = WekaWrapperSemGravidade.N4492be022(i);
        } else if (((Double) i[2]).doubleValue() > 0.638822) {
            p = WekaWrapperSemGravidade.N4c45261f7(i);
        }
        return p;
    }
    static double N4492be022(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 3;
        } else if (((Double) i[2]).doubleValue() <= 0.012488) {
            p = WekaWrapperSemGravidade.N6d3e692b3(i);
        } else if (((Double) i[2]).doubleValue() > 0.012488) {
            p = WekaWrapperSemGravidade.N39fa68f5(i);
        }
        return p;
    }
    static double N6d3e692b3(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 3;
        } else if (((Double) i[0]).doubleValue() <= 0.182569) {
            p = WekaWrapperSemGravidade.N7d83cc654(i);
        } else if (((Double) i[0]).doubleValue() > 0.182569) {
            p = 4;
        }
        return p;
    }
    static double N7d83cc654(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 4;
        } else if (((Double) i[3]).doubleValue() <= -9.617532) {
            p = 4;
        } else if (((Double) i[3]).doubleValue() > -9.617532) {
            p = 3;
        }
        return p;
    }
    static double N39fa68f5(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 4;
        } else if (((Double) i[2]).doubleValue() <= 0.097223) {
            p = WekaWrapperSemGravidade.N52ac6a506(i);
        } else if (((Double) i[2]).doubleValue() > 0.097223) {
            p = 5;
        }
        return p;
    }
    static double N52ac6a506(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 4;
        } else if (((Double) i[0]).doubleValue() <= 0.883931) {
            p = 4;
        } else if (((Double) i[0]).doubleValue() > 0.883931) {
            p = 5;
        }
        return p;
    }
    static double N4c45261f7(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 6.904059) {
            p = WekaWrapperSemGravidade.N2fc63b168(i);
        } else if (((Double) i[0]).doubleValue() > 6.904059) {
            p = WekaWrapperSemGravidade.N66a7191724(i);
        }
        return p;
    }
    static double N2fc63b168(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 3.436413) {
            p = WekaWrapperSemGravidade.N51935bbf9(i);
        } else if (((Double) i[2]).doubleValue() > 3.436413) {
            p = WekaWrapperSemGravidade.N582d483f20(i);
        }
        return p;
    }
    static double N51935bbf9(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -0.689272) {
            p = WekaWrapperSemGravidade.N605c453710(i);
        } else if (((Double) i[1]).doubleValue() > -0.689272) {
            p = WekaWrapperSemGravidade.N3007c0cf15(i);
        }
        return p;
    }
    static double N605c453710(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 1.967939) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() > 1.967939) {
            p = WekaWrapperSemGravidade.N5cce2fd11(i);
        }
        return p;
    }
    static double N5cce2fd11(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -1.923319) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > -1.923319) {
            p = WekaWrapperSemGravidade.N1b4c67d912(i);
        }
        return p;
    }
    static double N1b4c67d912(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 1.544581) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 1.544581) {
            p = WekaWrapperSemGravidade.N50c989ac13(i);
        }
        return p;
    }
    static double N50c989ac13(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 3.1772) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() > 3.1772) {
            p = WekaWrapperSemGravidade.N523e1b7f14(i);
        }
        return p;
    }
    static double N523e1b7f14(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 3.305) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() > 3.305) {
            p = 0;
        }
        return p;
    }
    static double N3007c0cf15(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 0;
        } else if (((Double) i[5]).doubleValue() <= 2.847387) {
            p = WekaWrapperSemGravidade.N480d0bb916(i);
        } else if (((Double) i[5]).doubleValue() > 2.847387) {
            p = 2;
        }
        return p;
    }
    static double N480d0bb916(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 2.626981) {
            p = WekaWrapperSemGravidade.N54157ffd17(i);
        } else if (((Double) i[0]).doubleValue() > 2.626981) {
            p = 5;
        }
        return p;
    }
    static double N54157ffd17(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 5;
        } else if (((Double) i[0]).doubleValue() <= 0.90812) {
            p = 5;
        } else if (((Double) i[0]).doubleValue() > 0.90812) {
            p = WekaWrapperSemGravidade.N765273e318(i);
        }
        return p;
    }
    static double N765273e318(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 1.275139) {
            p = WekaWrapperSemGravidade.N78ddd45e19(i);
        } else if (((Double) i[2]).doubleValue() > 1.275139) {
            p = 0;
        }
        return p;
    }
    static double N78ddd45e19(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 5;
        } else if (((Double) i[1]).doubleValue() <= -0.260897) {
            p = 5;
        } else if (((Double) i[1]).doubleValue() > -0.260897) {
            p = 0;
        }
        return p;
    }
    static double N582d483f20(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 3;
        } else if (((Double) i[4]).doubleValue() <= 0.833591) {
            p = 3;
        } else if (((Double) i[4]).doubleValue() > 0.833591) {
            p = WekaWrapperSemGravidade.N27382e5021(i);
        }
        return p;
    }
    static double N27382e5021(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() <= -0.270005) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() > -0.270005) {
            p = WekaWrapperSemGravidade.N42908c3f22(i);
        }
        return p;
    }
    static double N42908c3f22(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -0.534362) {
            p = WekaWrapperSemGravidade.N5479df1723(i);
        } else if (((Double) i[1]).doubleValue() > -0.534362) {
            p = 0;
        }
        return p;
    }
    static double N5479df1723(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= 7.151705) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > 7.151705) {
            p = 0;
        }
        return p;
    }
    static double N66a7191724(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 6.496885) {
            p = WekaWrapperSemGravidade.Nbf13d25(i);
        } else if (((Double) i[2]).doubleValue() > 6.496885) {
            p = WekaWrapperSemGravidade.N2964fe228(i);
        }
        return p;
    }
    static double Nbf13d25(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 0;
        } else if (((Double) i[1]).doubleValue() <= -1.588002) {
            p = WekaWrapperSemGravidade.N463c647726(i);
        } else if (((Double) i[1]).doubleValue() > -1.588002) {
            p = WekaWrapperSemGravidade.N5ca78ac027(i);
        }
        return p;
    }
    static double N463c647726(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() <= -9.27406) {
            p = 0;
        } else if (((Double) i[3]).doubleValue() > -9.27406) {
            p = 2;
        }
        return p;
    }
    static double N5ca78ac027(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= 0.223154) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > 0.223154) {
            p = 5;
        }
        return p;
    }
    static double N2964fe228(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 2;
        } else if (((Double) i[2]).doubleValue() <= 10.207135) {
            p = WekaWrapperSemGravidade.N5dcbd49429(i);
        } else if (((Double) i[2]).doubleValue() > 10.207135) {
            p = 2;
        }
        return p;
    }
    static double N5dcbd49429(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 2;
        } else if (((Double) i[1]).doubleValue() <= -1.352654) {
            p = 2;
        } else if (((Double) i[1]).doubleValue() > -1.352654) {
            p = 1;
        }
        return p;
    }
    static double N78710c8630(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 6;
        } else if (((Double) i[0]).doubleValue() <= 3.409034) {
            p = WekaWrapperSemGravidade.N18e078c231(i);
        } else if (((Double) i[0]).doubleValue() > 3.409034) {
            p = WekaWrapperSemGravidade.N23f59b0f37(i);
        }
        return p;
    }
    static double N18e078c231(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 6;
        } else if (((Double) i[4]).doubleValue() <= 0.008856) {
            p = 6;
        } else if (((Double) i[4]).doubleValue() > 0.008856) {
            p = WekaWrapperSemGravidade.N28b9cd6332(i);
        }
        return p;
    }
    static double N28b9cd6332(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 7;
        } else if (((Double) i[1]).doubleValue() <= 7.038155) {
            p = WekaWrapperSemGravidade.N2b55c39433(i);
        } else if (((Double) i[1]).doubleValue() > 7.038155) {
            p = WekaWrapperSemGravidade.N2639a53f36(i);
        }
        return p;
    }
    static double N2b55c39433(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 7;
        } else if (((Double) i[3]).doubleValue() <= 0.646035) {
            p = 7;
        } else if (((Double) i[3]).doubleValue() > 0.646035) {
            p = WekaWrapperSemGravidade.N5bb0ef4434(i);
        }
        return p;
    }
    static double N5bb0ef4434(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 7;
        } else if (((Double) i[1]).doubleValue() <= 2.797038) {
            p = 7;
        } else if (((Double) i[1]).doubleValue() > 2.797038) {
            p = WekaWrapperSemGravidade.N408dba9835(i);
        }
        return p;
    }
    static double N408dba9835(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 6;
        } else if (((Double) i[0]).doubleValue() <= 0.29101) {
            p = 6;
        } else if (((Double) i[0]).doubleValue() > 0.29101) {
            p = 7;
        }
        return p;
    }
    static double N2639a53f36(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 7;
        } else if (((Double) i[5]).doubleValue() <= 5.182561) {
            p = 7;
        } else if (((Double) i[5]).doubleValue() > 5.182561) {
            p = 6;
        }
        return p;
    }
    static double N23f59b0f37(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 7;
        } else if (((Double) i[4]).doubleValue() <= 1.181897) {
            p = 7;
        } else if (((Double) i[4]).doubleValue() > 1.181897) {
            p = WekaWrapperSemGravidade.N7f639afa38(i);
        }
        return p;
    }
    static double N7f639afa38(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 8;
        } else if (((Double) i[0]).doubleValue() <= 9.019775) {
            p = WekaWrapperSemGravidade.N5297b6f439(i);
        } else if (((Double) i[0]).doubleValue() > 9.019775) {
            p = 8;
        }
        return p;
    }
    static double N5297b6f439(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 7;
        } else if (((Double) i[4]).doubleValue() <= 7.143188) {
            p = 7;
        } else if (((Double) i[4]).doubleValue() > 7.143188) {
            p = 8;
        }
        return p;
    }   
}
