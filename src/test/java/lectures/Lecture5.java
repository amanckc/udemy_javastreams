package lectures;


import static org.assertj.core.api.Assertions.assertThat;

import beans.Car;
import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import mockdata.MockData;
import org.junit.Test;

public class Lecture5 {

  @Test
  public void understandingFilter() throws Exception {
    ImmutableList<Car> cars = MockData.getCars();
    Set<Car> collect = cars.stream()
        .filter(car -> car.getPrice() < 10000)
        .collect(Collectors.toSet());
    collect.forEach(System.out::println);
    System.out.println(collect.size());
  }

  @Test
  public void ourFirstMapping() throws Exception {
    // transform from one data type to another
    List<Person> people = MockData.getPeople();
    List<PersonDTO> collectDTOs = people.stream()
//        .map(person -> {
//          PersonDTO dto=new PersonDTO(person.getId(),person.getFirstName(),person.getAge());
//          return dto;
//        })
        .map(PersonDTO::map)
        .collect(Collectors.toList());

    //collectDTO.forEach(System.out::println);

    //assertThat()
    System.out.println(collectDTOs.size());
  }

  @Test
  public void averageCarPrice() throws Exception {
    // calculate average of car prices
    double average = MockData.getCars()
        .stream()
        .mapToDouble(Car::getPrice)
        .average()
        .orElse(0);
    System.out.println(average);


  }

  @Test
  public void test() throws Exception {
    MockData.getCars().forEach(System.out::println);
  }
}



