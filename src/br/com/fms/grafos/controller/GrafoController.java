package br.com.fms.grafos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.fms.grafos.util.CaminhoMinimo;
import br.com.fms.grafos.util.Util;

@Controller
public class GrafoController {

	@Autowired
	Util util;

	@Autowired
	CaminhoMinimo caminho;

	@RequestMapping("home")
	public String home() {
		return "menu";
	}

	@RequestMapping("form")
	public String matriz() {
		return "matriz";
	}

	@RequestMapping("criaMatriz")
	public String criaMatriz(@RequestParam("size") int size, Model model) {

		int v[] = new int[size];

		model.addAttribute("tam", v);
		model.addAttribute("size", v.length);

		return "matriz";
	}

	@RequestMapping("salvar")
	public String salvaMatriz(@RequestParam(value = "dados") int[] v,
			@RequestParam("size") int size, Model model) {

		model.addAttribute("m", util.convertToMatriz(v, size));
		model.addAttribute("size", size);

		return "matriz-criada";
	}

	@RequestMapping("euleriano")
	public String euleriano(@RequestParam("dados") int[] v,
			@RequestParam("size") int size, Model model) {

		int a[][] = util.convertToMatriz(v, size);

		if (util.caminhoEuleriano(a, size)) {
			model.addAttribute("success", "Existe");
		} else {
			model.addAttribute("danger", "Não existe");
		}
		model.addAttribute("m", a);
		model.addAttribute("size",size);

		return "caminho-euleriano";
	}

	@RequestMapping("formCaminho")
	public String formCaminho(@RequestParam("dados") int[] v,
			@RequestParam("size") int size, Model model) {

		int a[][] = util.convertToMatriz(v, size);
		model.addAttribute("m", a);
		model.addAttribute("size", size);

		return "caminho-minimo";
	}

	@RequestMapping("minimo")
	public String caminho(@RequestParam("dados") int[] v,
			@RequestParam("size") int size, CaminhoMinimo cM, Model model) {

		int a[][] = util.convertToMatriz(v, size);
		
		model.addAttribute("m", a);
		model.addAttribute("success", caminho.minimo(a, cM.getX(), cM.getY()));
		model.addAttribute("size", size);
		model.addAttribute("teste", "teste"); //for form select

		return "caminho-minimo";
	}

}
