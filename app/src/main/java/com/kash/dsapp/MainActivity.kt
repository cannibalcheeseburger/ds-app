package com.kash.dsapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.department.view.*
import java.security.AccessControlContext

class MainActivity : AppCompatActivity() {

    var ListOfDept = ArrayList<Department>()
    var adapter:DeptAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //load departments
        //CSE
        ListOfDept.add(Department("Computer Science and Engineering","\n" +
                "Located in Hamirpur district of Himachal Pradesh, NIT Hamirpur enjoys a really scenic " +
                "environment and pleasant weather. Established in the year 1986, as REC Hamirpur, NIT Hamirpur " +
                "has been declared as the Institute of National Importance under the Act of Parliament, 2007. " +
                "Established in 1989 as the Department of Computer Science & Engineering, we have an excellent & " +
                "rich history and an outstanding record of contributions to the profession and community. The" +
                " Department is well recognized for excellence in facilities and teaching.\n",R.drawable.cse))
        //ECE
        ListOfDept.add(Department("Electronic and Comunication Engineering","\n" +
                "Established in the year 1988, the Electronics & Communication Engineering (E&CE) Department NIT " +
                "Hamirpur HP, has built an international reputation for excellence in teaching, research and service." +
                " Electronics engineers are changing the world to a comfortable global home. The information and technology" +
                " revolution has been built on the advances of Electronics. The E&CE Department takes pride in its" +
                " high national rankings and the international recognition its faculty has received from their peers.\n",R.drawable.ece))
        //CE
        ListOfDept.add(Department("Civil Engineering","\n" +
                "National Institute of Technology, Hamirpur was established in the year 1986 and the Civil Engineering " +
                "Department is part of the institute since its inception. Civil Engineering is considered to be the most" +
                " versatile branch among all the engineering branches. It is the branch with lot of diversity right from" +
                " structural to transportation engineering, environmental to hydrology to hydraulics engineering, geology to" +
                " geo-technology to earthquake engineering; Civil Engineering can be considered as a single largest branch " +
                "among all the engineering branches. Being one of the primary Engineering Departments of the Institute, the" +
                " Department of Civil Engineering offers B. Tech., M. Tech. and Ph.D. degrees programmers, accredited by " +
                "National Board of Accreditation for five years since January 2008 and has been imparting quality education" +
                " to its students",R.drawable.ce))

        //ME
        ListOfDept.add(Department("Mechanical Engineering","\n" +
                "\n" +
                "The Department of Mechanical Engineering came into its existence right from the inception of " +
                "the then Regional Engineering College Hamirpur (now National Institute of Technology Hamirpur) " +
                "in the year 1986 and served as catering department to other disciplines. The discipline of Mechanical" +
                " Engineering started offering undergraduate programme leading to four year Bachelor of Technology " +
                "(B.Tech) degree in Mechanical Engineering in the year 1994. The first batch was started with an intake" +
                " of 30 students which has now been enhanced to 60 students by the Ministry of HRD, Government of India" +
                " from the session 2006-2007 which has further been enhanced to 90 students. Since its existence, 21 " +
                "Batches of Undergraduate students with B.Tech Degree in Mechanical Engineering, 14 batches of Postgraduate" +
                " programme i.e. M.Tech. (Thermal Engineering) and 7 batches of M.Tech. (CAD CAM Engineering)" +
                " have passed.",R.drawable.me))

        //CHE
        ListOfDept.add(Department("Chemical Engineering","\n" +
                "The Department of Chemical Engineering was established in the year 2013, with a mission to impart high" +
                " quality engineering education and to mould the students to meet the ever growing demand of technical" +
                " manpower in the area of Chemical Engineering. The department offers four years B. Tech programme in " +
                "Chemical Engineering with a total intake of 75 students; M.Tech. program in Chemical Engineering (to be" +
                " started from July, 2020) with a total intake of 15 students; and Ph.D. program. The department has a strong" +
                " core curriculum complemented by electives in the important emerging areas of Chemical Engineering." +
                " The department comprises of eleven different laboratories for the undergraduates catering to the needs " +
                "of the curriculum. In addition, analytical instruments, computer facilities and research laboratories for " +
                "the postgraduates and doctoral resources are already in place. All the faculties are highly qualified and " +
                "well dedicated to teaching and research in various fields of chemical engineering as well as in different" +
                " interdisciplinary areas of engineering.",R.drawable.che))

        //EE

        ListOfDept.add(Department("Electrical Engineering","\n" +
                "Electrical Engineering Department, established in the year 1986, is one of the oldest departments of " +
                "National Institute of Technology Hamirpur. The Department has been imparting quality education at undergraduate " +
                "and post-graduate level. The faculty members have been active in teaching and research activities. " +
                "The course curriculum is being revised from time to time so as to keep students abreast with latest developments" +
                " and emerging technologies. Various departmental laboratories have been strengthened and modernized by " +
                "procuring state of art equipment’s. The department is also equipped with latest experimental and computational " +
                "facilities for taking up R&D and consultancy activities in different areas of Electrical Engineering. Alumni of " +
                "the department are well placed in various reputed government / non-government administrative, academic, research, " +
                "engineering organizations in the country. Many of them are well settled in various reputed organization in abroad." +
                " Department produces not only knowledgeable, skilled, trained employable engineers but also a good citizen having " +
                "concern with society, environment and ethical issues.",R.drawable.ee))

        //initial adapter with array list
        adapter = DeptAdapter(this,ListOfDept)
        tvListView.adapter = adapter

    }

    class DeptAdapter:BaseAdapter{

        var ListOfDept = ArrayList<Department>()
        var context:Context?=null
        constructor(context: Context, ListOfDept: ArrayList<Department>):super(){
            this.ListOfDept = ListOfDept
            this.context = context
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val Dept = ListOfDept[position]
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myView = inflater.inflate(R.layout.department,null)
            myView.tvName.text = Dept.name
            //add Description 94 12:40
            myView.ivDept.setImageResource(Dept.image!!)
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
