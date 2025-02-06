package com.rush_ai;

import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import org.vosk.LibVosk;
import org.vosk.LogLevel;

@Mod(RushAI.MOD_ID)
public class RushAI {
    public static final String MOD_ID = "rush_ai";
    private static final Logger LOGGER = LogUtils.getLogger();

    public RushAI() {
        // ✅ 로그 레벨 설정 (init() 제거)
        LibVosk.setLogLevel(LogLevel.DEBUG);

        // ✅ `getInstance()`가 아니라 `get()` 사용
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        LOGGER.info("Rush AI 모드가 로드되었습니다!");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        LOGGER.info("Rush AI 클라이언트 설정 완료!");
    }
}
