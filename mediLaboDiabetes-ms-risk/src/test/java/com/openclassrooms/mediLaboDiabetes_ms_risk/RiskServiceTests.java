package com.openclassrooms.mediLaboDiabetes_ms_risk;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.openclassrooms.mediLaboDiabetes_ms_risk.service.RiskService;

@SpringBootTest
class RiskServiceTests {
	@Autowired
	RiskService riskService;

	List<String> listNotes = new ArrayList<>();

	@BeforeEach
	void setupTests() {
		listNotes = new ArrayList<>();
		listNotes.add("Taille, Poids, Cholestérol, Vertige et Réaction");
	}

	@Test
	void testGetNumberOfSymptoms() {
		assertEquals(5, riskService.getNumberOfSymptoms(listNotes));
	}

	@Test
	void testGetRiskLevel_None() {
		assertEquals(0, riskService.getRiskLevel(0, 25, ""));
	}

	@Test
	void testGetRiskLevel_Borderline() {
		assertEquals(1, riskService.getRiskLevel(3, 35, "F"));
		assertEquals(1, riskService.getRiskLevel(2, 30, "M"));
		assertEquals(1, riskService.getRiskLevel(5, 69, "B"));
	}

	@Test
	void testGetRiskLevel_Old_InDanger() {
		assertEquals(2, riskService.getRiskLevel(6, 32, "F"));
		assertEquals(2, riskService.getRiskLevel(7, 32, "M"));
	}

	@Test
	void testGetRiskLevel_M_InDanger() {
		assertEquals(2, riskService.getRiskLevel(3, 25, "M"));
	}

	@Test
	void testGetRiskLevel_F_InDanger() {
		assertEquals(2, riskService.getRiskLevel(4, 25, "F")
		);
	}

	@Test
	void testGetRiskLevel_Old_EarlyOnset() {
		assertEquals(3, riskService.getRiskLevel(8, 32, "M"));
		assertEquals(3, riskService.getRiskLevel(8, 32, "F"));
	}

	@Test
	void testGetRiskLevel_M_EarlyOnset() {
		assertEquals(3, riskService.getRiskLevel(5, 25, "M"));
		assertEquals(3, riskService.getRiskLevel(50, 25, "M"));
	}

	@Test
	void testGetRiskLevel_F_EarlyOnset() {
		assertEquals(3, riskService.getRiskLevel(7, 25, "F"));
		assertEquals(3, riskService.getRiskLevel(50, 25, "F"));
	}

}
