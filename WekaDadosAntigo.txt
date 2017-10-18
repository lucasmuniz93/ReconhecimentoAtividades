package com.example.lukaas.trabalhocompmovel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class WekaWrapper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reconhecimento);
    }
    public static double classify(Object[] i)
            throws Exception {

        double p = Double.NaN;
        p = WekaWrapper.N772cc83c125(i);
        return p;
    }
    static double N772cc83c125(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 4;
        } else if (((Double) i[3]).doubleValue() <= -7.916874) {
            p = WekaWrapper.N7957a26e126(i);
        } else if (((Double) i[3]).doubleValue() > -7.916874) {
            p = WekaWrapper.N322a2117152(i);
        }
        return p;
    }
    static double N7957a26e126(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 4;
        } else if (((Double) i[2]).doubleValue() <= 0.41555) {
            p = WekaWrapper.N15fcfbd9127(i);
        } else if (((Double) i[2]).doubleValue() > 0.41555) {
            p = WekaWrapper.N3280b0ed135(i);
        }
        return p;
    }
    static double N15fcfbd9127(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 4;
        } else if (((Double) i[0]).doubleValue() <= 0.764489) {
            p = WekaWrapper.N1473e6de128(i);
        } else if (((Double) i[0]).doubleValue() > 0.764489) {
            p = WekaWrapper.N7861aacd134(i);
        }
        return p;
    }
    static double N1473e6de128(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 3;
        } else if (((Double) i[1]).doubleValue() <= -1.088188) {
            p = 3;
        } else if (((Double) i[1]).doubleValue() > -1.088188) {
            p = WekaWrapper.N58fa144129(i);
        }
        return p;
    }
    static double N58fa144129(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 4;
        } else if (((Double) i[2]).doubleValue() <= 0.057329) {
            p = WekaWrapper.N418f2749130(i);
        } else if (((Double) i[2]).doubleValue() > 0.057329) {
            p = WekaWrapper.N38116b21132(i);
        }
        return p;
    }
    static double N418f2749130(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 3;
        } else if (((Double) i[0]).doubleValue() <= 0.151998) {
            p = WekaWrapper.N33df2e92131(i);
        } else if (((Double) i[0]).doubleValue() > 0.151998) {
            p = 4;
        }
        return p;
    }
    static double N33df2e92131(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 4;
        } else if (((Double) i[1]).doubleValue() <= 0.952485) {
            p = 4;
        } else if (((Double) i[1]).doubleValue() > 0.952485) {
            p = 3;
        }
        return p;
    }
    static double N38116b21132(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 4;
        } else if (((Double) i[1]).doubleValue() <= -0.277962) {
            p = 4;
        } else if (((Double) i[1]).doubleValue() > -0.277962) {
            p = WekaWrapper.N406c68e6133(i);
        }
        return p;
    }
    static double N406c68e6133(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 5;
        } else if (((Double) i[1]).doubleValue() <= 1.29306) {
            p = 5;
        } else if (((Double) i[1]).doubleValue() > 1.29306) {
            p = 3;
        }
        return p;
    }
    static double N7861aacd134(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 4;
        } else if (((Double) i[2]).doubleValue() <= 0.017449) {
            p = 4;
        } else if (((Double) i[2]).doubleValue() > 0.017449) {
            p = 5;
        }
        return p;
    }
    static double N3280b0ed135(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 2;
        } else if (((Double) i[1]).doubleValue() <= -0.725683) {
            p = WekaWrapper.N17b9dff136(i);
        } else if (((Double) i[1]).doubleValue() > -0.725683) {
            p = WekaWrapper.N1cc2c473151(i);
        }
        return p;
    }
    static double N17b9dff136(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 0;
        } else if (((Double) i[0]).doubleValue() <= 5.619527) {
            p = WekaWrapper.N22f3fe6e137(i);
        } else if (((Double) i[0]).doubleValue() > 5.619527) {
            p = WekaWrapper.N31dae6d3143(i);
        }
        return p;
    }
    static double N22f3fe6e137(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() <= 2.04827) {
            p = 0;
        } else if (((Double) i[2]).doubleValue() > 2.04827) {
            p = WekaWrapper.N57b10f3f138(i);
        }
        return p;
    }
    static double N57b10f3f138(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -1.914978) {
            p = WekaWrapper.N6081dafc139(i);
        } else if (((Double) i[1]).doubleValue() > -1.914978) {
            p = WekaWrapper.N3d482776140(i);
        }
        return p;
    }
    static double N6081dafc139(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 6.684772) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > 6.684772) {
            p = 2;
        }
        return p;
    }
    static double N3d482776140(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() <= -1.066066) {
            p = 1;
        } else if (((Double) i[5]).doubleValue() > -1.066066) {
            p = WekaWrapper.Nf5ae3f141(i);
        }
        return p;
    }
    static double Nf5ae3f141(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() <= 2.365776) {
            p = 0;
        } else if (((Double) i[4]).doubleValue() > 2.365776) {
            p = WekaWrapper.N5fe281e9142(i);
        }
        return p;
    }
    static double N5fe281e9142(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() <= -1.671622) {
            p = 1;
        } else if (((Double) i[1]).doubleValue() > -1.671622) {
            p = 0;
        }
        return p;
    }
    static double N31dae6d3143(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 6.640611) {
            p = WekaWrapper.N4dd50409144(i);
        } else if (((Double) i[2]).doubleValue() > 6.640611) {
            p = WekaWrapper.N607cdfda145(i);
        }
        return p;
    }
    static double N4dd50409144(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= 4.971825) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() > 4.971825) {
            p = 2;
        }
        return p;
    }
    static double N607cdfda145(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 2;
        } else if (((Double) i[1]).doubleValue() <= -1.498244) {
            p = 2;
        } else if (((Double) i[1]).doubleValue() > -1.498244) {
            p = WekaWrapper.N2bdaf7f5146(i);
        }
        return p;
    }
    static double N2bdaf7f5146(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 1;
        } else if (((Double) i[0]).doubleValue() <= 11.066325) {
            p = WekaWrapper.N4dd06023147(i);
        } else if (((Double) i[0]).doubleValue() > 11.066325) {
            p = WekaWrapper.N525d6763150(i);
        }
        return p;
    }
    static double N4dd06023147(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 2;
        } else if (((Double) i[2]).doubleValue() <= 7.044262) {
            p = 2;
        } else if (((Double) i[2]).doubleValue() > 7.044262) {
            p = WekaWrapper.N28c0c0dc148(i);
        }
        return p;
    }
    static double N28c0c0dc148(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 1;
        } else if (((Double) i[4]).doubleValue() <= 4.41371) {
            p = WekaWrapper.N2ec44811149(i);
        } else if (((Double) i[4]).doubleValue() > 4.41371) {
            p = 1;
        }
        return p;
    }
    static double N2ec44811149(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() <= 7.741263) {
            p = 1;
        } else if (((Double) i[2]).doubleValue() > 7.741263) {
            p = 2;
        }
        return p;
    }
    static double N525d6763150(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 2;
        } else if (((Double) i[3]).doubleValue() <= -9.331589) {
            p = 2;
        } else if (((Double) i[3]).doubleValue() > -9.331589) {
            p = 1;
        }
        return p;
    }
    static double N1cc2c473151(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 5;
        } else if (((Double) i[2]).doubleValue() <= 4.597817) {
            p = 5;
        } else if (((Double) i[2]).doubleValue() > 4.597817) {
            p = 1;
        }
        return p;
    }
    static double N322a2117152(Object []i) {
        double p = Double.NaN;
        if (i[0] == null) {
            p = 6;
        } else if (((Double) i[0]).doubleValue() <= 2.626981) {
            p = WekaWrapper.N3e226383153(i);
        } else if (((Double) i[0]).doubleValue() > 2.626981) {
            p = WekaWrapper.N41414590160(i);
        }
        return p;
    }
    static double N3e226383153(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 7;
        } else if (((Double) i[3]).doubleValue() <= -1.144358) {
            p = 7;
        } else if (((Double) i[3]).doubleValue() > -1.144358) {
            p = WekaWrapper.N7fd6d5b154(i);
        }
        return p;
    }
    static double N7fd6d5b154(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 6;
        } else if (((Double) i[4]).doubleValue() <= 0.623453) {
            p = WekaWrapper.Nd16d08b155(i);
        } else if (((Double) i[4]).doubleValue() > 0.623453) {
            p = WekaWrapper.N2fbf1803158(i);
        }
        return p;
    }
    static double Nd16d08b155(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 6;
        } else if (((Double) i[3]).doubleValue() <= 1.576678) {
            p = WekaWrapper.N6e576aa7156(i);
        } else if (((Double) i[3]).doubleValue() > 1.576678) {
            p = 7;
        }
        return p;
    }
    static double N6e576aa7156(Object []i) {
        double p = Double.NaN;
        if (i[2] == null) {
            p = 6;
        } else if (((Double) i[2]).doubleValue() <= 0.305178) {
            p = WekaWrapper.N43c42295157(i);
        } else if (((Double) i[2]).doubleValue() > 0.305178) {
            p = 7;
        }
        return p;
    }
    static double N43c42295157(Object []i) {
        double p = Double.NaN;
        if (i[1] == null) {
            p = 6;
        } else if (((Double) i[1]).doubleValue() <= 9.261805) {
            p = 6;
        } else if (((Double) i[1]).doubleValue() > 9.261805) {
            p = 7;
        }
        return p;
    }
    static double N2fbf1803158(Object []i) {
        double p = Double.NaN;
        if (i[4] == null) {
            p = 7;
        } else if (((Double) i[4]).doubleValue() <= 5.906766) {
            p = 7;
        } else if (((Double) i[4]).doubleValue() > 5.906766) {
            p = WekaWrapper.N149607f7159(i);
        }
        return p;
    }
    static double N149607f7159(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 8;
        } else if (((Double) i[5]).doubleValue() <= 1.919563) {
            p = 8;
        } else if (((Double) i[5]).doubleValue() > 1.919563) {
            p = 7;
        }
        return p;
    }
    static double N41414590160(Object []i) {
        double p = Double.NaN;
        if (i[3] == null) {
            p = 8;
        } else if (((Double) i[3]).doubleValue() <= 1.948528) {
            p = WekaWrapper.N237317a7161(i);
        } else if (((Double) i[3]).doubleValue() > 1.948528) {
            p = 7;
        }
        return p;
    }
    static double N237317a7161(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 8;
        } else if (((Double) i[5]).doubleValue() <= 8.557045) {
            p = 8;
        } else if (((Double) i[5]).doubleValue() > 8.557045) {
            p = WekaWrapper.N74db7cca162(i);
        }
        return p;
    }
    static double N74db7cca162(Object []i) {
        double p = Double.NaN;
        if (i[5] == null) {
            p = 7;
        } else if (((Double) i[5]).doubleValue() <= 8.857678) {
            p = 7;
        } else if (((Double) i[5]).doubleValue() > 8.857678) {
            p = 8;
        }
        return p;
    }
}