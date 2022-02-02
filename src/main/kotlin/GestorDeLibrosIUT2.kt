import java.awt.Dimension
import java.awt.event.MouseAdapter
import java.awt.event.MouseEvent
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JTextField

open class GestorDeLibrosIUT2: JFrame() {
    private val textField1: JTextField? = null
    private val button1: JButton? = null
    private val Jlabel1: JLabel? = null
    private val Jlabeld: JLabel? = null

    init {
        var d = Dimension(500, 500)
        this.size = d

    }

    fun respuestaGui( msn:String){
        button1!!.addMouseListener(object : MouseAdapter() {
            override fun mouseClicked(e: MouseEvent) {
                super.mouseClicked(e)
                Jlabel1!!.text = msn
            }
        })
    }
}