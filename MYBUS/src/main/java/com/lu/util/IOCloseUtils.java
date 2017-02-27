package com.lu.util;

import java.io.Closeable;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import org.apache.commons.logging.Log;

public class IOCloseUtils {

	private static final Log DEBUG = PssLogFactory.getDebugLog();

	/**
	 * 
	 * @param is
	 */
	public static void close(InputStream is) {

		if (null == is) {
			return;
		}

		try {
			is.close();
			if (DEBUG.isDebugEnabled()) {
				DEBUG.debug("close input stream");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param is
	 */
	public static void close(InputStreamReader is) {

		if (null == is) {
			return;
		}

		try {
			is.close();
			if (DEBUG.isDebugEnabled()) {
				DEBUG.debug("close input stream");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 
	 * @param os
	 */
	public static void close(OutputStream os) {

		if (null == os) {
			return;
		}

		try {
			os.flush();
			os.close();
			if (DEBUG.isDebugEnabled()) {
				DEBUG.debug("close output stream");
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			try {
				os.close();
			} catch (Exception e) {

				if (DEBUG.isDebugEnabled()) {
					DEBUG.debug("close output stream");
				}

			}
		}

	}

	private static void closeQuiet(Closeable single) {
		if (null != single) {
			try {
				single.close();
			} catch (Exception e) {

				if (DEBUG.isDebugEnabled()) {
					DEBUG.debug("close  stream");
				}
			}
		}
	}

	/**
	 * close a lot of {@link Closeable}, such as : {@link InputStream},
	 * {@link OutputStream} and others that can be close
	 * 
	 * @param cls
	 */
	public static void closeBatch(Closeable... cls) {

		for (Closeable os : cls) {
			try {
				closeQuiet(os);
			} catch (Exception ioe) {
				if (DEBUG.isDebugEnabled()) {
					DEBUG.debug("close output stream");
				}
			}
		}

	}

}
