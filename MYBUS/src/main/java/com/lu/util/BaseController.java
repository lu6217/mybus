package com.lu.util;

public abstract class BaseController {


	public static interface Taker {

		void process(RestResponse rr);
	}

	/**
	 * 
	 * @param taker
	 * @param rr
	 * @return
	 */
	public RestResponse processSimple(RestResponse rr, Taker taker) {

		try {

			taker.process(rr);

		} catch (Exception e) {
			e.printStackTrace();
			rr.setResult(false);
			PssLogFactory.getErrorLog().error(this.getClass().getSimpleName(), e);
			if (e.getClass().equals(RuntimeException.class)) {
				rr.setMessage(e.getMessage());
			} else {

				rr.setMessage("œµÕ≥√¶,«Î…‘∫Û");
			}
		}

		return rr;

	}
}