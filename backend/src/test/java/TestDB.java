import com.project.config.AppConfig;
import com.project.model.Job;
import com.project.model.User;
import com.project.repository.JobRepo;
import com.project.repository.UserRepo;
import com.project.service.UserService;
import org.dozer.Mapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;


/**
 * Created by sergeyy on 12/12/16.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
public class TestDB {

    @Autowired
    JobRepo jobRepo;

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;


    @Autowired
    Mapper dtoMapper;


    /*@Test
    public void souldPersistJobToDb() {
        Job job = new Job();
        job.setTitle("Java Developer");
        job.setDescription("dsdsdsfdafafadadasdadasdas");
        job.setUserId(1L);


        assertNotNull(jobRepo.createJob(job));




    }
*/


   /* @Test
    public void shouldReturnListOfJobs() {
        int start=0;
        int max = 5;
        System.out.println(jobRepo.getJobList(start,max).size());

        assertNotNull(jobRepo.getJobList(start,max));

    }*/


    /*@Test
    public void shouldUpdateJob() {
        Job job = new Job();
        job.setDescription("Ambitious");
        job.setTitle("C# dev");
        job.setDeadLine(new GregorianCalendar(2017, 01, 25));

        assertTrue(jobRepo.updateJob(1L,job));


    }

    */

    /*@Test
    public void shouldDeleteJob() {


        assertTrue( jobRepo.deleteJob(1L));
    }*/


   /* @Test
    public void shouldPersistToDb() {
        User user = new User();
        user.setFirstName("Armen");
        user.setLastName("Yer");
        user.setEmail("armdev@mail.com");
        user.setPassword("sdsdsdd");

        userRepo.createUser(user);
    }*/





/*    @Test
    public void shouldNotCreateUser() {
        UserDTO userDto = new UserDTO();
        userDto.setFirstName("Vardan");
        userDto.setLastName("Vardanyan");
        userDto.setEmail("vardan@mail.com");

        assertNull(userService.saveUser(null));

    }*/


  /*  @Test
    public void shouldNotDeleteUser() {
        assertFalse(userService.deleteUser(6565656565656565656L));

    }*/


    /*@Test
    public void shouldNotUpdateUser() {
        User user = userRepo.findUserById(2L);
        user.setLastName("Baghdasaryan");
        UserDTO userDto = dtoMapper.map(user,UserDTO.class);


        assertTrue(userService.updateUser(userDto));

    }*/

    /*@Test
    public void shouldNotFindUser() {

        assertNull(userService.getUserById(6565656L));

    }*/


  /*  @Test
    public void shouldGetJobList() {
        assertNotNull(jobRepo.getJobListByUserId(1L));

    }*/




}
