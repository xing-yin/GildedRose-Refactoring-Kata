package com.gildedrose;


import static com.google.common.base.Charsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 1.构建安全网
 *
 * @author yinxing
 * @since 2023/11/22
 **/
public class GlidedRoseSafetyNet {

  @Test
  public void should_always_aligin_with_baseline() throws IOException {
    String got = TextTestFixture.getBaseline();
    String wantBaseline = Files.toString(new File("src/test/baseline.txt"), UTF_8);
    assertEquals(wantBaseline, got);
  }

}
