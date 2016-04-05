<?php namespace App\Http\Controllers;
use Illuminate\Support\Facades\Response;
use Illuminate\Support\Facades\URL;
use Input;
use App\Course;
use App\CourseDetails;
use Session;
use Mail;
class MainController extends Controller {
	/*
	|--------------------------------------------------------------------------
	| Welcome Controller
	|--------------------------------------------------------------------------
	|
	| This controller renders the "marketing page" for the application and
	| is configured to only allow guests. Like most of the other sample
	| controllers, you are free to modify or remove it as you desire.
	|
	*/
	/**
	 * Create a new controller instance.
	 *
	 * @return void
	 */
	public function __construct()
	{
		$this->middleware('guest');
	}
	/**
	 * Show the application welcome screen to the user.
	 *
	 * @return Response
	 */
	public function index()
	{


			 $courses = Course::all();

			 return view('welcome', ['courses' => $courses]);


	}
	public function resume()
	{
		return view('resume');
	}
	/** Portfolio **/
	public function portfolio()
	{
		return view('portfolio');
	}
	//download demo apk
  public function downloadDemo()
	{
     $file = public_path('download/BattleDodgeballDemo.apk');
     return Response::download($file);
  }
	public function skill()
	{
		return view('skill');
	}
	public function contact()
	{
		return view('contact');
	}
	/** Footprint **/
	public function footprint()
	{
		$footprint = Footprint::all();
		return view('footprint')->with('footprint',$footprint);
	}
	//when footprint form is submitted
	public function createFP(){
		$data = Input::all();
		$footprint = new Footprint($data);
		$footprint->save();
		return redirect('/footprint')->with('message', 'You have left your footprint!');
	}

  //send email
  public function sendEmail(){
    $data = array();
    Mail::send('emails.demo', $data, function($message)
    {
        $message->to('kj2park@uwaterloo.ca', 'Kijung Park')
        //->to('kjparkdavid@gmail.com')
        //->to('cw2park@uwaterloo.ca')
        //->to('jw3an@uwaterloo.ca')
        ->subject('Demo CompE Lab Section Change');
    });

    return 'success';
  }

  /** Theme 1 **/
  public function theme()
	{
		return view('theme.theme');
	}

  public function theme_resume()
	{
		return view('theme.resume');
	}

  public function theme_portfolio()
	{
		return view('theme.portfolio');
	}


  /** Theme 2 **/
   public function theme2()
	{
		return view('theme2.theme2');
	}
}
