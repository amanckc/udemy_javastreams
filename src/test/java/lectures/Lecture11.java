package lectures;

import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture11 {

  @Test
  public void joiningStrings() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    
    String joined="";
    for(String name:names)
    	joined+=name+"-";
    	
    System.out.println(joined);
    System.out.println(joined.substring(0, joined.length()-2));
  }

  @Test
  public void joiningStringsWithStream() throws Exception {
    List<String> names = ImmutableList.of("anna", "john", "marcos", "helena", "yasmin");
    
   String join= names.stream()
    .collect(Collectors.joining("->"));
    System.out.println(join);
  }
}
