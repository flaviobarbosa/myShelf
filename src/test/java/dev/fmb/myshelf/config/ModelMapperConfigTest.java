package dev.fmb.myshelf.config;

import dev.fmb.myShelf.config.ModelMapperConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ModelMapperConfig.class)
public class ModelMapperConfigTest {

    @Autowired
    ModelMapperConfig modelMapperConfig;

    @Test
    void modelMapperConfigTest() {
        ModelMapper mapper = modelMapperConfig.modelMapper();
        Assertions.assertThat(mapper).isInstanceOf(ModelMapper.class);
    }
}
