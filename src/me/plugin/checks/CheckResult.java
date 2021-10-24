package me.plugin.checks;

public class CheckResult
{
  private Level level;
  private String message;
  private CheckType type;
  
  public CheckResult(Level level, String message, CheckType type)
  {
    this.level = level;
    this.message = message;
    this.type = type;
  }
  
  public Level getLevel()
  {
    return this.level;
  }
  
  public String getMessage()
  {
    return this.message;
  }
  
  public CheckType getType()
  {
    return this.type;
  }
  
  public boolean failed()
  {
    return this.level != Level.PASSED;
  }
}
