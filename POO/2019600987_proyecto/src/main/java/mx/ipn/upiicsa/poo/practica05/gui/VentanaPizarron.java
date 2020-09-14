package mx.ipn.upiicsa.poo.practica05.gui;

import mx.ipn.upiicsa.poo.practica05.json.Serializer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import mx.ipn.upiicsa.poo.practica05.Exception.DrawingException;
import mx.ipn.upiicsa.poo.practica05.dao.PizarronDao;
import mx.ipn.upiicsa.poo.practica05.model.Circle;
import mx.ipn.upiicsa.poo.practica05.model.Cuadrado;
import mx.ipn.upiicsa.poo.practica05.model.Diagrama;
import mx.ipn.upiicsa.poo.practica05.model.Figura;
import mx.ipn.upiicsa.poo.practica05.model.Imagen;
import mx.ipn.upiicsa.poo.practica05.model.Line;
import mx.ipn.upiicsa.poo.practica05.model.Pencil;
import mx.ipn.upiicsa.poo.practica05.model.Poligono;
import mx.ipn.upiicsa.poo.practica05.model.Rectangulo;
import mx.ipn.upiicsa.poo.practica05.model.Text;
import mx.ipn.upiicsa.poo.practica05.model.Triangulo;

/**
 * 
 * @author manuelr
 *
 */
public class VentanaPizarron extends JFrame {
	private static final long serialVersionUID = 1L;
	private static final int UNSELECTED_TOOL = -1;
	private static final int TOOL_CIRCLE = 1;
	private static final int TOOL_SQUARE = 2;
	private static final int TOOL_TRIANGLE = 3;
	private static final int TOOL_RECTANGLE = 4;
	private static final int TOOL_POLYGON = 5;
	private static final int TOOL_TEXT = 6;
	private static final int TOOL_IMAGE = 7;
	private static final int TOOL_PENCIL = 8;
	private static final int TOOL_LINE = 9;
	private static final int TOOL_SELECT = 10;
	private static final int TOOL_ERASE = 11;
	private static final int DRAWING_ACTIVE = 1;
	private static final int DRAWING_INACTIVE = 0;
	private static final int SELECT_ACTIVE = 1;
	private static final int SELECT_INACTIVE = 0;
	private static final int SIZE_MIN = 10;
	private static final int SIZE_MAX = 600;
	private static final int SIZE_INIT = 70;
	private static final int BORDER_MIN = 1;
	private static final int BORDER_MAX = 40;
	private static final int BORDER_INIT = 1;
	private JPanel toolPanel;
	private JPanel dashboardPanel;
	private JPanel logPanel;
	private JPanel editPanel;
	private JMenuBar menuBar;
	private JMenu menuDiagrama;
	private JMenuItem menuItemGuardar;
	private JMenuItem menuItemEditar;
	private JMenuItem menuItemCargar;
	private JMenuItem menuItemEliminar;

	private JButton btnCircle;
	private JButton btnSquare;
	private JButton btnTriangle;
	private JButton btnRectangle;
	private JButton btnPolygon;
	private JButton btnText;
	private JButton btnImage;
	private JButton btnPencil;
	private JButton btnLine;
	private JButton btnSelect;
	private JTextArea logText;
	private JButton btnBorrar;

	private JButton btnChangeBorderColor;
	private JButton btnChangeFillColor;

	private JSlider sliderFigureSize;
	private JTextField fieldFigureSize;

	private JSlider sliderBorderSize;
	private JTextField fieldBorderSize;

	private static final Serializer<Figura> serializer = new Serializer<>();

	private Figura pencilTemp;
	private Figura figuraTemp;
	private Figura lineTemp;

	private List<Figura> figuras;

	private Image image = null;

	private int selectedTool;
	private int drawingState;

	private int selectState;

	public VentanaPizarron() {
		initComponents();
		selectedTool = UNSELECTED_TOOL;
		drawingState = DRAWING_INACTIVE;
		selectState = SELECT_INACTIVE;
	}

	private void initComponents() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setResizable(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		instantiateComponents();
		buildLayout();
		initializeListeners();
		setVisible(true);
	}

	private void instantiateComponents() {
		menuBar = new JMenuBar();
		menuDiagrama = new JMenu("Diagrama");
		menuBar.add(menuDiagrama);
		menuItemGuardar = new JMenuItem("Guardar diagrama");
		menuItemCargar = new JMenuItem("Cargar diagrama");
		menuItemEliminar = new JMenuItem("Eliminar diagrama");
		menuItemEditar = new JMenuItem("Editar diagrama");
		menuDiagrama.add(menuItemGuardar);
		menuDiagrama.add(menuItemCargar);
		menuDiagrama.add(menuItemEditar);
		menuDiagrama.add(menuItemEliminar);
		setJMenuBar(menuBar);
		toolPanel = new JPanel();
		editPanel = new JPanel();
		editPanel.setVisible(false);
		dashboardPanel = new JPanel() {
			private static final long serialVersionUID = 1L;
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				for (Figura f : figuras) {
					f.paint(g);
				}
			}
		};
		dashboardPanel.setBackground(Color.WHITE);
		logPanel = new JPanel();
		btnCircle = new JButton(new ImageIcon(getClass().getResource("/circulo.png")));
		btnSquare = new JButton(new ImageIcon(getClass().getResource("/cuadrado.png")));
		btnTriangle = new JButton(new ImageIcon(getClass().getResource("/triangulo.png")));
		btnRectangle = new JButton(new ImageIcon(getClass().getResource("/rectangular.png")));
		btnPolygon = new JButton(new ImageIcon(getClass().getResource("/hexagono.png")));
		btnText = new JButton(new ImageIcon(getClass().getResource("/tipo.png")));
		btnImage = new JButton(new ImageIcon(getClass().getResource("/foto.png")));
		btnPencil = new JButton(new ImageIcon(getClass().getResource("/lapiz.png")));
		btnLine = new JButton(new ImageIcon(getClass().getResource("/linea.png")));
		btnSelect = new JButton(new ImageIcon(getClass().getResource("/dedo.png")));
		btnBorrar = new JButton(new ImageIcon(getClass().getResource("/goma-de-borrar.png")));
		logText = new JTextArea("Bienvenido \n");
		logText.setRows(4);
		logText.setColumns(123);
		logText.setEditable(false);
		figuras = new ArrayList<Figura>();
		btnChangeBorderColor = new JButton("Color de borde");
		btnChangeFillColor = new JButton("Color de fondo");
		sliderFigureSize = new JSlider(JSlider.HORIZONTAL, SIZE_MIN, SIZE_MAX, SIZE_INIT);
		fieldFigureSize = new JTextField(Integer.toString(sliderFigureSize.getValue()));
		fieldFigureSize.setEditable(false);
		sliderBorderSize = new JSlider(JSlider.HORIZONTAL, BORDER_MIN, BORDER_MAX, BORDER_INIT);
		fieldBorderSize = new JTextField(Integer.toString(sliderBorderSize.getValue()));
		fieldBorderSize.setEditable(false);
	}

	private void buildLayout() {
		Container pane = getContentPane();
		pane.setLayout(new BorderLayout());
		toolPanel.setLayout(new GridLayout(11, 1));
		toolPanel.setPreferredSize(new Dimension(50, 50));
		toolPanel.add(btnCircle);
		toolPanel.add(btnSquare);
		toolPanel.add(btnTriangle);
		toolPanel.add(btnRectangle);
		toolPanel.add(btnPolygon);
		toolPanel.add(btnText);
		toolPanel.add(btnImage);
		toolPanel.add(btnPencil);
		toolPanel.add(btnLine);
		toolPanel.add(btnSelect);
		toolPanel.add(btnBorrar);
		editPanel.setLayout(new GridLayout(15, 1));
		editPanel.setPreferredSize(new Dimension(200, 50));
		editPanel.add(new Label("Editar Figura"));
		editPanel.add(btnChangeFillColor);
		editPanel.add(btnChangeBorderColor);
		editPanel.add(new JLabel("Tamaño de la figura"));
		editPanel.add(fieldFigureSize);
		editPanel.add(sliderFigureSize);
		editPanel.add(new JLabel("Tamaño del borde"));
		editPanel.add(fieldBorderSize);
		editPanel.add(sliderBorderSize);
		pane.add(toolPanel, BorderLayout.WEST);
		pane.add(editPanel, BorderLayout.EAST);
		pane.add(dashboardPanel, BorderLayout.CENTER);
		JScrollPane logTextScrollPane = new JScrollPane(logText, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		logPanel.add(logTextScrollPane);
		logText.setMaximumSize(logPanel.getMaximumSize());
		pane.add(logPanel, BorderLayout.SOUTH);
	}

	private void initializeListeners() {
		menuItemGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!figuras.isEmpty()) {
					String json = serializer.getFigurasSerializer(figuras);
					Diagrama diagramaNuevo = dialogoAgregarDiagrama(json);
					if (diagramaNuevo != null) {
						PizarronDao.guardarDiagrama(diagramaNuevo);
					}
				} else {
					String message = "Debes realizar un dibujo en el panel";
					JOptionPane.showMessageDialog(dashboardPanel, message);
				}

			}
		});
		menuItemCargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Diagrama selectedDiagram = dialogoTablaDiagramas();
				if (selectedDiagram != null) {
					Diagrama diagrama = PizarronDao.obtenerDiagrama(selectedDiagram.getId());
					String json = diagrama.getJson();
					figuras = serializer.getFigurasList(json);
					dashboardPanel.repaint();
				} else {
					JOptionPane.showMessageDialog(dashboardPanel, "No se selecciono ningún diagrama");
				}
			}
		});
		menuItemEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!figuras.isEmpty()) {
					String json = serializer.getFigurasSerializer(figuras);
					Diagrama oldDiagrama = dialogoTablaDiagramas();
					if (oldDiagrama != null) {
						Diagrama newDiagrama = dialogoAgregarDiagrama(json);
						int resultado = JOptionPane.showConfirmDialog(null, "Esta seguro que desea editar el diagrama",
								"editar diagrama", JOptionPane.OK_CANCEL_OPTION);
						if (resultado == JOptionPane.OK_OPTION) {
							Boolean diagramaEliminado = PizarronDao.actualizarDiagrama(newDiagrama,
									oldDiagrama.getId());
							if (diagramaEliminado != false) {
								JOptionPane.showMessageDialog(dashboardPanel, "Se ha editado el diagrama");
							}
						}
					} else {
						JOptionPane.showMessageDialog(dashboardPanel, "No se selecciono ningún diagrama");
					}
				} else {
					String message = "Debes realizar un dibujo en el panel antes de editar un diagrama";
					JOptionPane.showMessageDialog(dashboardPanel, message);
				}

			}
		});
		menuItemEliminar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Diagrama selectedDiagram = dialogoTablaDiagramas();
				if (selectedDiagram != null) {
					int resultado = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el diagrama",
							"Eliminar diagrama", JOptionPane.OK_CANCEL_OPTION);
					if (resultado == JOptionPane.OK_OPTION) {
						Boolean diagramaEliminado = PizarronDao.eliminarDiagrama(selectedDiagram.getId());
						if (diagramaEliminado != false) {
							JOptionPane.showMessageDialog(dashboardPanel, "Se ha eliminado el diagrama");
						}
					}
				}	
			}
		});
		sliderBorderSize.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				figuraTemp.setStroke(sliderBorderSize.getValue());
				fieldBorderSize.setText(Integer.toString(sliderBorderSize.getValue()));
				dashboardPanel.repaint();
			}
		});
		sliderFigureSize.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				figuraTemp.setSize(sliderFigureSize.getValue());
				fieldFigureSize.setText(Integer.toString(sliderFigureSize.getValue()));
				dashboardPanel.repaint();
			}
		});
		btnCircle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_CIRCLE;
			}
		});
		btnSquare.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_SQUARE;
			}
		});
		btnTriangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_TRIANGLE;
			}
		});
		btnRectangle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_RECTANGLE;
			}
		});
		btnPolygon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_POLYGON;
			}
		});
		btnText.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_TEXT;
			}
		});
		btnImage.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				image = selectImage();
				if (image != null) {
					selectedTool = TOOL_IMAGE;
				}
			}
		});
		btnPencil.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_PENCIL;
			}
		});
		btnLine.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_LINE;
			}
		});
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_SELECT;
			}
		});
		btnBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedTool = TOOL_ERASE;
			}
		});
		btnChangeFillColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(VentanaPizarron.this, "Color de fondo",
						figuraTemp.getFillColor());
				if (color != null) {
					figuraTemp.setFillColor(color);
					dashboardPanel.repaint();
				}
			}
		});
		btnChangeBorderColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Color color = JColorChooser.showDialog(VentanaPizarron.this, "Color de borde",
						figuraTemp.getFillColor());
				if (color != null) {
					figuraTemp.setBorderColor(color);
					dashboardPanel.repaint();
				}
			}
		});
		dashboardPanel.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (drawingState == DRAWING_ACTIVE && selectedTool == TOOL_PENCIL) {
					pencilTemp = null;
				}
			}
			@Override
			public void mousePressed(MouseEvent e) {
				if (drawingState == DRAWING_ACTIVE && selectedTool == TOOL_PENCIL) {
					@SuppressWarnings("unused")
					String mensaje;
					pencilTemp = getFigure(e.getX(), e.getY());
				}
				if (selectedTool == TOOL_LINE) {
					lineTemp = getFigure(e.getX(), e.getY());
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				drawingState = DRAWING_INACTIVE;
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				drawingState = DRAWING_ACTIVE;
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				if (selectedTool != TOOL_SELECT && drawingState == DRAWING_ACTIVE & selectedTool != TOOL_ERASE) {
					@SuppressWarnings("unused")
					Figura figura = getFigure(e.getX(), e.getY());
				} else if (selectedTool == TOOL_SELECT) {
					figuraTemp = selectFigure(e.getX(), e.getY());
					if (figuraTemp != null) {
						actualizarEstado(SELECT_ACTIVE);
					} else {
						actualizarEstado(SELECT_INACTIVE);
					}
					dashboardPanel.repaint();
				} else if (selectedTool == TOOL_ERASE) {
					figuraTemp = selectFigure(e.getX(), e.getY());
					figuras.remove(figuraTemp);
					dashboardPanel.repaint();
				}

			}
		});
		dashboardPanel.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseMoved(MouseEvent e) {
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				if (drawingState == DRAWING_ACTIVE && selectedTool == TOOL_PENCIL) {
					Pencil pencil = (Pencil) pencilTemp;
					pencil.addPoint(e.getX(), e.getY());
					pencil.paint(dashboardPanel.getGraphics());
				}
				if (selectState == SELECT_ACTIVE) {
					moveFigure(e.getX(), e.getY(), figuraTemp);
				}
				if (selectedTool == TOOL_LINE) {
					Line line = (Line) lineTemp;
					line.setX2(e.getX());
					line.setY2(e.getY());
					lineTemp = line;
					dashboardPanel.repaint();
				}
			}
		});

	}
	
	private void actualizarEstado(int action) {
		if (action == SELECT_ACTIVE) {
			selectState = SELECT_ACTIVE;
			editPanel.setVisible(true);
		} else if (action == SELECT_INACTIVE) {
			selectState = SELECT_INACTIVE;
			editPanel.setVisible(false);
		}
	}

	public Figura getFigure(int x, int y) {
		Figura figura = null;
		String mensaje;
		try {
			figura = getFigureDraw(x, y);
			figura.paint(dashboardPanel.getGraphics());
			mensaje = "Se dibujo un " + figura + " en las cordenadas " + "[" + x + ", " + y + "]" + "\n";
			figuras.add(figura);
			logText.append(mensaje);
		} catch (DrawingException exception) {
			mensaje = "Exception";
		} 
		return figura;
	}

	private Diagrama dialogoTablaDiagramas() {
		JPanel panel = new JPanel(new GridLayout(0, 1));
		List<Diagrama> diagramas = PizarronDao.obtenerDiagramas();
		Diagrama selectedDiagrama = null;
		String[] columnNames = { "Nombre", "Descripción", "Fecha de creación", "Fecha de modificación" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM, FormatStyle.SHORT);
		diagramas.forEach(diagrama -> {
			Object[] objs = { diagrama.getNombre(), diagrama.getDescripcion(),
					diagrama.getFechaCreacion().format(formatter), diagrama.getFechaActualizacion().format(formatter) };
			tableModel.addRow(objs);
		});
		JTable table = new JTable(tableModel);
		table.setPreferredScrollableViewportSize(new Dimension(800, 300));
		table.setFillsViewportHeight(true);
		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane);
		int result = JOptionPane.showConfirmDialog(null, panel, "Elige el diagrama", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			if (table.getSelectedRow() != -1) {
				selectedDiagrama = diagramas.get(table.getSelectedRow());
			}
		}
		return selectedDiagrama;
	}

	private Diagrama dialogoAgregarDiagrama(String json) {
		Diagrama diagrama = null;
		JTextField field1 = new JTextField("");
		JTextField field2 = new JTextField("");
		JPanel panel = new JPanel(new GridLayout(0, 1));
		panel.add(new JLabel("Nombre:"));
		panel.add(field1);
		panel.add(new JLabel("Descripción:"));
		panel.add(field2);
		int result = JOptionPane.showConfirmDialog(null, panel, "Guardar diagrama", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			String nombre = field1.getText();
			String descripcion = field2.getText();
			LocalDateTime fechaCreacion = LocalDateTime.now();
			LocalDateTime fechaModificacion = LocalDateTime.now();
			diagrama = new Diagrama(nombre, descripcion, fechaCreacion, fechaModificacion, json);

		}
		return diagrama;
	}

	private Figura selectFigure(int x, int y) {
		Figura figuraSeleccionada = null;
		for (Figura figura : figuras) {
			if (figura.limits(x, y)) {
				figuraSeleccionada = figura;
			}
		}
		return figuraSeleccionada;
	}

	private void moveFigure(int x, int y, Figura figura) {
		if (figura != null && x >= 0 && y >= 0) {
			figura.setX(x);
			figura.setY(y);
			dashboardPanel.repaint();
		}
	}

	private String obtenerTexto() {
		String texto = "default text";
		String res = JOptionPane.showInputDialog("Ingrese el texto");
		if (res != null) {
			texto = res;
		}
		return texto;
	}

	private Image selectImage() {
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG , PNG & GIF", "jpg", "png", "gif");
		fc.setFileFilter(filtroImagen);
		int seleccion = fc.showOpenDialog(this.dashboardPanel);
		Image imagen = null;
		if (seleccion == JFileChooser.APPROVE_OPTION) {
			File fichero = fc.getSelectedFile();
			try {
				imagen = ImageIO.read(new File(fichero.getAbsolutePath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return imagen;
	}

	private Figura getFigureDraw(int x, int y) throws DrawingException {
		Figura figura = null;
		if (selectedTool == UNSELECTED_TOOL) {
			throw new DrawingException();
		} else if (selectedTool == TOOL_CIRCLE) {
			figura = Circle.getDefault(x, y);
		} else if (selectedTool == TOOL_SQUARE) {
			figura = Cuadrado.getDefault(x, y);
		} else if (selectedTool == TOOL_RECTANGLE) {
			figura = Rectangulo.getDefault(x, y);
		} else if (selectedTool == TOOL_TRIANGLE) {
			figura = Triangulo.getDefault(x, y);
		} else if (selectedTool == TOOL_PENCIL) {
			figura = Pencil.getDefault(x, y);
		} else if (selectedTool == TOOL_TEXT) {
			figura = Text.getDefault(x, y, obtenerTexto());
		} else if (selectedTool == TOOL_POLYGON) {
			figura = Poligono.getDefault(x, y);
		} else if (selectedTool == TOOL_IMAGE) {
			figura = Imagen.getDefault(x, y, image);
		} else if (selectedTool == TOOL_LINE) {
			figura = Line.getDefault(x, y);
		}
		return figura;
	}
}
