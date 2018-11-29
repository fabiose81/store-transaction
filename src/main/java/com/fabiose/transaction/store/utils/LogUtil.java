package com.fabiose.transaction.store.utils;

import org.apache.log4j.Logger;

import com.fabiose.transaction.store.enums.LogEnum;

public class LogUtil {

	final static Logger logger = Logger.getLogger(LogUtil.class);

	public static void write(String msg, LogEnum logEnum) {

		synchronized (logger) {

			if (logEnum == LogEnum.DEBUG) {
				logger.debug(CalendarUtil.dateFormatted().concat(" :: ").concat(msg).concat("\n"));
			} else {
				logger.error(CalendarUtil.dateFormatted().concat(" :: ").concat(msg).concat("\n"));
			}

		}

	}
}
