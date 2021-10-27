package com.douzone.container.config.videosystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.douzone.container.videosystem.Avengers;
import com.douzone.container.videosystem.DVDPlayer;
import com.douzone.container.videosystem.DigitalVideoDisc;

@Configuration
public class DVDPlayerConfig {
	@Bean
	public Avengers avengers() {
		return new Avengers();
	}

	// 주입(Injection) 하기1
	// Bean 생성 메소드를 직접 호출하는 방법
	// 생성자 주입
	//@Bean
	public DVDPlayer dvdPlayer01() {
		return new DVDPlayer(avengers());
	}

	// 주입(Injection) 하기2
	// 파라미터로 빈 전달하기
	// Bean 생성 메소드를 직접 호출하는 방법
	//@Bean
	public DVDPlayer dvdPlayer02(DigitalVideoDisc dvd) {
		return new DVDPlayer(dvd);
	}

	// 주입(Injection) 하기2
	// 파라미터로 빈 전달하기
	// setter 주입
	@Bean
	public DVDPlayer dvdPlayer03(DigitalVideoDisc dvd) {
		DVDPlayer dvdplayer =  new DVDPlayer(dvd);
		dvdplayer.setDvd(dvd);
		
		return dvdplayer;
	}
}
