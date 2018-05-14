package lectures;

import static org.assertj.core.api.Assertions.assertThat;

import beans.Person;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import mockdata.MockData;
import org.assertj.core.util.Lists;
import org.junit.Test;


public class Lecture1 {

  @Test
  public void imperativeApproach() throws IOException {
    List<Person> people = MockData.getPeople();
   
    List<Person>  peeps=Lists.newArrayList();
    final int limit=10;
    int count=0;

    for(Person p:people){
      if(p.getAge()<=18)
      {
        peeps.add(p);
        count++;
        if(count==limit)
          break;
      }
    }


    for(Person p:peeps)
    {
      System.out.println(p);
    }


  }

  @Test
  public void declarativeApproachUsingStreams() throws Exception {


    MockData.getPeople().stream().filter(person -> person.getAge()<=18)
         .limit(10)
         .collect(Collectors.toList())
        .forEach(System.out::println);


  }
}
