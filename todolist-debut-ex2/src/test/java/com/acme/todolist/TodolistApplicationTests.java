package com.acme.todolist;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.acme.todolist.configuration.TodolistApplication;
import com.acme.todolist.domain.TodoItem;
@SpringBootTest(classes=TodolistApplication.class)
@RunWith(SpringRunner.class)
class TodolistApplicationTests {


	@Test
	public void testRG1Late() {

		// Créer un objet TodoItem avec une date et une note pour la règle RG1
		TodoItem item = new TodoItem("1", Instant.now().minus(2, ChronoUnit.DAYS), "Faire les courses");

		// Vérifier que la méthode "finalContent()" ajoute la note "[LATE!]" si
		// l'élément est en retard
		assertEquals("[LATE!] Faire les courses", item.finalContent());
	}
	
	@Test
	public void testRG1NotLate() {

		// Créer un objet TodoItem avec une date et une note pour la règle RG1
		TodoItem item = new TodoItem("1", Instant.now(), "Faire les courses");

		// Vérifier que la méthode "finalContent()" ajoute la note "[LATE!]" si
		// l'élément est en retard
		assertEquals("Faire les courses", item.finalContent());
	}
}
