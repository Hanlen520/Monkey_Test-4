/*    */ package org.apache.log4j.pattern;
/*    */ 
/*    */ import org.apache.log4j.spi.LocationInfo;
/*    */ import org.apache.log4j.spi.LoggingEvent;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class LineLocationPatternConverter
/*    */   extends LoggingEventPatternConverter
/*    */ {
/* 34 */   private static final LineLocationPatternConverter INSTANCE = new LineLocationPatternConverter();
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */   private LineLocationPatternConverter()
/*    */   {
/* 41 */     super("Line", "line");
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static LineLocationPatternConverter newInstance(String[] options)
/*    */   {
/* 51 */     return INSTANCE;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */   public void format(LoggingEvent event, StringBuffer output)
/*    */   {
/* 58 */     LocationInfo locationInfo = event.getLocationInformation();
/*    */     
/* 60 */     if (locationInfo != null) {
/* 61 */       output.append(locationInfo.getLineNumber());
/*    */     }
/*    */   }
/*    */ }


/* Location:              /home/liuwenhua/tools/LoNg(Official)_ALPS/LoNg_v2.1710.5 (2)/LoNg.jar!/org/apache/log4j/pattern/LineLocationPatternConverter.class
 * Java compiler version: 4 (48.0)
 * JD-Core Version:       0.7.1
 */