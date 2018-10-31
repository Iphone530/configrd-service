package io.configrd.service;

import java.io.StringReader;
import java.util.Properties;
import javax.ws.rs.core.MediaType;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.configrd.core.SystemProperties;


public class GetTextValuesFromClasspathITCase extends AbstractTestSuiteITCase {

  private static final Logger logger =
      LoggerFactory.getLogger(GetTextValuesFromClasspathITCase.class);
 
  
  
  @BeforeClass
  public static void setup() throws Throwable {

    System.setProperty(SystemProperties.CONFIGRD_CONFIG, "classpath:classpath-repos.yaml");
    TestConfigServer.serverStart();
   
    logger.info("Running " + GetTextValuesFromClasspathITCase.class.getName());

  }

  @AfterClass
  public static void teardown() throws Exception {
    TestConfigServer.serverStop();
  }

  @Before
  @Override
  public void init() throws Exception {
    super.init();
    target = client.target("http://localhost:8891/configrd/v1/");
    content = MediaType.TEXT_PLAIN_TYPE;
    accept = MediaType.TEXT_PLAIN_TYPE;
  }

  @Test
  @Override
  public void testGetPropertiesFromJsonFile() throws Exception {
    super.testGetPropertiesFromJsonFile();
  }

  @Test
  @Override
  public void testGetPropertiesFromYamlFile() throws Exception {
    super.testGetPropertiesFromYamlFile();
  }
  
  @Override
  public Properties convert(String body) throws Exception {
    Properties props = new Properties();
    props.load(new StringReader(body));
    return props;
  }


}
