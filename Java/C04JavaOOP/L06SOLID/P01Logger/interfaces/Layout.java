package L06SOLID.Exercise.P01Logger.interfaces;

import L06SOLID.Exercise.P01Logger.enumerations.ReportLevel;

public interface Layout {
    String format(String time, String message, ReportLevel reportLevel);
}
