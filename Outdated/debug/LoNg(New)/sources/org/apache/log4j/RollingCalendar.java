package org.apache.log4j;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import org.apache.log4j.spi.ErrorCode;

/* compiled from: DailyRollingFileAppender */
class RollingCalendar extends GregorianCalendar {
    private static final long serialVersionUID = -3560331770601814177L;
    int type = -1;

    RollingCalendar() {
    }

    RollingCalendar(TimeZone tz, Locale locale) {
        super(tz, locale);
    }

    /* Access modifiers changed, original: 0000 */
    public void setType(int type) {
        this.type = type;
    }

    public long getNextCheckMillis(Date now) {
        return getNextCheckDate(now).getTime();
    }

    public Date getNextCheckDate(Date now) {
        setTime(now);
        switch (this.type) {
            case 0:
                set(13, 0);
                set(14, 0);
                add(12, 1);
                break;
            case 1:
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(11, 1);
                break;
            case ErrorCode.FLUSH_FAILURE /*2*/:
                set(12, 0);
                set(13, 0);
                set(14, 0);
                if (get(11) >= 12) {
                    set(11, 0);
                    add(5, 1);
                    break;
                }
                set(11, 12);
                break;
            case ErrorCode.CLOSE_FAILURE /*3*/:
                set(11, 0);
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(5, 1);
                break;
            case ErrorCode.FILE_OPEN_FAILURE /*4*/:
                set(7, getFirstDayOfWeek());
                set(11, 0);
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(3, 1);
                break;
            case ErrorCode.MISSING_LAYOUT /*5*/:
                set(5, 1);
                set(11, 0);
                set(12, 0);
                set(13, 0);
                set(14, 0);
                add(2, 1);
                break;
            default:
                throw new IllegalStateException("Unknown periodicity type.");
        }
        return getTime();
    }
}
