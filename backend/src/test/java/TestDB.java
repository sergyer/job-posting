import com.project.config.AppConfig;
import com.project.dto.UserDTO;
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


  /*  @Test
    public void souldPersistJobToDb() {
        Job javaJob = new Job();
        javaJob.setDescription("Self-motivated person");
        javaJob.setTitle("Java dev");
        javaJob.setDeadLine(new GregorianCalendar(2017, 01, 10));

        Job seeSharpJob = new Job();
        seeSharpJob.setDescription("Ambitious");
        seeSharpJob.setTitle("C# dev");
        seeSharpJob.setDeadLine(new GregorianCalendar(2017, 01, 15));


        Long id1 = jobRepo.createJob(javaJob);
        Long id2 = jobRepo.createJob(seeSharpJob);


        assertEquals(new Long(1), id1);
        assertEquals(new Long(2), id2);


    }*/

    /*@Test
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

/*

    @Test
    public void shouldPersistToDb() {
        User user = new User();
        user.setFirstName("Sergey");
        user.setLastName("Yer");
        user.setEmail("serg@mail.com");
        user.setPassword("sdsdsdd");

        userRepo.createUser(user);
    }
*/

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






}
