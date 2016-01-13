/**
 *Copyright (c) 1997, 2015,BEST WONDER CO.,LTD. All rights reserved.
 */

package com.ldm;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * @ClassName: TestItext2
 * @Description: TODO
 * @author Administrator
 * @date 2015年11月30日 上午11:34:07
 */
public class TestItext2 {

	// 基本字体和样式
	static BaseFont bfChinese = null;
	static Font fontChinese = null;
	static String CHANGE_LINE = "\n    ";
	static Font UNDER_LINE = null;

	/**
	 * 这里
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		Document document = new Document(PageSize.A4, 33, 33, 33, 33);
		PdfWriter writer = null;
		try {
			bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
			fontChinese = new Font(bfChinese, 14, Font.NORMAL);
			UNDER_LINE = new Font(bfChinese, 14, Font.UNDERLINE);

			writer = PdfWriter.getInstance(document, new FileOutputStream("d:/征信报告.pdf"));
			// 打开
			document.open();
			Paragraph title = new Paragraph();
			// 设置页面格式
			title.setSpacingBefore(8);
			title.setSpacingAfter(2);
			title.setAlignment(1);
			// 设置PDF标题
			title.add(new Chunk("企 业 贷 款 报 告", new Font(bfChinese, 16, Font.BOLD)));
			document.add(title);
			// 抬头
			// Paragraph head = getParagraph("致：程序员们");
			// head.setSpacingBefore(30);
			// document.add(head);
			// 文字参数
			Map<String, String> map = new HashMap<String, String>();
			map.put("name", "东东东");
//			map.put("sex", "男");
//			map.put("height", "178");
			// map.put("time", new Date().toString());
			// 文字数据
			String str = getString();
			List<Paragraph> l = getPars(str, map);

			for (Paragraph p : l) {
				document.add(p);
			}
			// 表格数据
			// 创建一个有4列的表格
//			PdfPTable table = new PdfPTable(4);
//			// 可以对表格进行控制
//
//			// 默认会生成普通cell,特殊cell 要通过PdfPCell 进行设置
//			table.addCell(getParagraph("发票税率"));
//			table.addCell(getParagraph("发票编号"));
//			table.addCell(getParagraph("发票类型"));
//			table.addCell(getParagraph("金额"));
			// 剩余的表格数据
//			List<String> cells = getTableParams();
//			for (String cell : cells) {
//				table.addCell(getParagraph(cell));
//			}
//			document.add(table);

			document.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	// 给Dcouemnt 添加内容
	public Document setDocumentContext(Document document, List<Paragraph> paragraphs) {
		if (paragraphs != null) {
			for (Paragraph paragraph : paragraphs) {
				try {
					document.add(paragraph);
				} catch (DocumentException e) {
					e.printStackTrace();
				}
			}
		}
		return document;
	}

	public static String setParams(String context, List<String> params, String str_replace) {
		if (context == null || params == null || str_replace == null) {
			return context;
		}
		for (String param : params) {
			Chunk chunk = new Chunk(param, UNDER_LINE);
			context = context.replaceFirst(str_replace, chunk.toString());
		}
		return context;
	}

	public static void setParams(String param, Paragraph pa) {
		pa.add(new Chunk(param, UNDER_LINE));
	}

	public static String setParams(String context, List<String> params) {
		return setParams(context, params, "\\?");
	}

	public static List<Chunk> getListChunks(List<String> params) {
		List<Chunk> chunks = new ArrayList<Chunk>();
		for (String param : params) {
			Chunk e = new Chunk(param, UNDER_LINE);
			chunks.add(e);
		}
		return chunks;
	}

	public static List<String> getList() {
		List<String> params = new ArrayList<String>();
		params.add("计划-08-采购-购置-传输08-202-002-006");
		params.add("2008503180");
		params.add("993290.00");
		params.add("到货款");
		params.add("20％");
		params.add("198658.00");
		params.add("壹拾玖万捌仟陆佰伍拾捌圆整");
		params.add("1");
		params.add("198658.00");
		return params;
	}

	public static final String BEGIN = "{";
	public static final String END = "}";
	public static final String NEW_LINE = "#";
	public static final float DEFAULT_LEADING = 20;
	public static final float DEFAULT_LINE_INDENT = 30;

	public static String getString2() {
		String str = "贵司与我司签订的采购合同，合同编号:" + "{conNo}，采购订单号：{poNo} ，该合同金额为:{conMoney} 。"
				+ "{#}  发票明细:{pp}  {#}  魔法:{xx} {#} OVER！";
		return str;
	}

	public static String getString() {
		String str = "{#}工程师们，大家晚上好,我叫: {name},性别:{sex},身高:{height}cm." + "当前时间是：{time}{#}"
				+ "这是文字行的测试数据，下面我们尝试表格型的测试数据。" + "{#}这里展示我们的订单信息：{#}";
		return str;
	}

	public static List<String> getTableParams() {
		// 为了方便就按顺序存放
		List<String> l = new ArrayList<String>();
		l.add("%12");
		l.add("T9090990");
		l.add("食品类发票");
		l.add("1000.0");

		l.add("%15");
		l.add("Q12023");
		l.add("服务类发票");
		l.add("9999.0");
		return l;
	}

	public static List<Paragraph> getPars(String context, Map<String, String> map) {
		int index = 0;
		List<Paragraph> list = new ArrayList<Paragraph>();
		Paragraph p = getDefaultParagraph(null);
		while ((index = context.indexOf(BEGIN)) > -1) {
			String text = context.substring(0, index);
			context = context.substring(index, context.length());
			index = context.indexOf(END);
			String param = null;
			if (index > 0) {
				param = context.substring(BEGIN.length(), index);
			}
			p.add(text);
			if (!NEW_LINE.equals(param)) {
				Object value = map.get(param);
				if (value != null) {
					p.add(new Chunk(value.toString(), UNDER_LINE));
				} else {
					p.add(new Chunk(param));
				}
			} else {
				list.add(p);
				p = getDefaultParagraph(null);
				p.setSpacingBefore(0);
			}
			context = context.substring(index + END.length(), context.length());
		}
		list.add(p);
		list.add(getParagraph(context));
		return list;
	}

	// 默认样式
	public static Paragraph getParagraph(String context) {
		return getParagraph(context, fontChinese);
	}

	// 指定字体样式
	public static Paragraph getParagraph(String context, Font font) {
		return new Paragraph(context, font);
	}

	// 获得新行,首行缩进,和行间距
	public static Paragraph getNewParagraph(String context, float fixedLeading, float firstLineIndent) {
		Paragraph p = getParagraph(context);
		p.setLeading(fixedLeading);
		p.setFirstLineIndent(firstLineIndent);
		return p;
	}

	// 默认段落样式
	public static Paragraph getDefaultParagraph(String context) {
		Paragraph p = getParagraph(context);
		// 默认行间距
		p.setLeading(DEFAULT_LEADING);
		// 默认首行空隙
		p.setFirstLineIndent(DEFAULT_LINE_INDENT);
		return p;
	}

}
