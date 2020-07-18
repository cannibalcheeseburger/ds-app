package com.kash.dsapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_dept_info.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.department.view.*
import kotlinx.android.synthetic.main.department.view.ivDept
import kotlinx.android.synthetic.main.department.view.tvName
import java.util.*

class MainActivity : AppCompatActivity() {

    var ListOfDept = LinkedList<Department>()
    var adapter:DeptAdapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load departments
        //CSE
        ListOfDept.add(Department("Computer Science and Engineering", getString(R.string.CSE_des),R.drawable.cse))
        //ECE
        ListOfDept.add(Department("Electronic and Comunication Engineering",getString(R.string.ECE_des)  ,R.drawable.ece))
        //CE
        ListOfDept.add(Department("Civil Engineering",getString(R.string.CE_des),R.drawable.ce))

        //ME
        ListOfDept.add(Department("Mechanical Engineering",getString(R.string.ME_des),R.drawable.me))

        //CHE
        ListOfDept.add(Department("Chemical Engineering",getString(R.string.CE_des),R.drawable.che))

        //EE

        ListOfDept.add(Department("Electrical Engineering",getString(R.string.EE_des),R.drawable.ee))

        //initial adapter with array list
        adapter = DeptAdapter(this,ListOfDept)
        tvListView.adapter = adapter

    }

    class DeptAdapter:BaseAdapter{

        var ListOfDept = LinkedList<Department>()
        var context:Context?=null
        constructor(context: Context, ListOfDept: LinkedList<Department>):super(){
            this.ListOfDept = ListOfDept
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val Dept = ListOfDept[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflater.inflate(R.layout.department,null)
            myView.tvName.text = Dept.name
            myView.ivDept.setImageResource(Dept.image!!)
            myView.setOnClickListener{
                val intent = Intent(context,DeptInfo::class.java)
                intent.putExtra("name",Dept.name!!)
                intent.putExtra("des",Dept.des!!)
                intent.putExtra("image",Dept.image!!)
                context!!.startActivity(intent)
            }
            return myView
        }

        override fun getItem(position: Int): Any {
            return ListOfDept[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return ListOfDept.size
        }

    }
}
