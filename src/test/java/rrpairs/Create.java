package rrpairs;

import java.io.IOException;

import base.BaseClass;
import resources.PayloadConfigs;

public class Create extends BaseClass {

	public static String createsomething() throws IOException {

		generatepayload(PayloadConfigs.NORM_FP, PayloadConfigs.TGT_NORM_FP, "Value", ENV.Key1());
		generatepayload(PayloadConfigs.TGT_NORM_FP, PayloadConfigs.TGT_NORM_FP, "Valuec", ENV.Key2());
		generatepayload(PayloadConfigs.TGT_NORM_FP, PayloadConfigs.TGT_NORM_FP, "Valued", ENV.Key3());

		String genpayload = generateStringFromResource(PayloadConfigs.TGT_NORM_FP);
		return genpayload;

	}

	public static String createotherthing() throws IOException {

		generatepayload(PayloadConfigs.OTH_PATH, PayloadConfigs.TGT_OTH_PATH, "Value", ENV.Key1());
		generatepayload(PayloadConfigs.TGT_OTH_PATH, PayloadConfigs.TGT_OTH_PATH, "Valuec", ENV.Key2());
		generatepayload(PayloadConfigs.TGT_OTH_PATH, PayloadConfigs.TGT_OTH_PATH, "Valued", ENV.Key3());

		String genpayload = generateStringFromResource(PayloadConfigs.TGT_OTH_PATH);
		return genpayload;

	}
}
